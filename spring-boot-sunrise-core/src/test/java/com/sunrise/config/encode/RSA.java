package com.sunrise.config.encode;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

public class RSA {

	private String string = "你好，RSA!";

	public static void main(String[] args) {
		RSA rsa = new RSA();
		rsa.jdkRSA();
	}

	public void jdkRSA() {
		try {
			// 实例化密钥生成器
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			// 初始化密钥生成器
			keyPairGenerator.initialize(2048);
			// 生成密钥对
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			// 公钥
			RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			// 私钥
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
			// 公钥
			byte[] publicKeyBytes = rsaPublicKey.getEncoded();
			String publicKeyStr = Base64.encodeBase64String(publicKeyBytes);
			System.out.println("jdkRSA公钥：" + publicKeyStr);
			// 私钥
			byte[] privateKeyBytes = rsaPrivateKey.getEncoded();
			String privateKeyStr = Base64.encodeBase64String(privateKeyBytes);
			System.out.println("jdkRSA私钥：" + privateKeyStr);
			// 签名
			byte[] signBytes = getSignature(privateKeyStr, string.getBytes());
			String signStr = Base64.encodeBase64String(signBytes);
			System.out.println("jdkMD5-RSA签名：" + signStr);
			//
			byte[] encodeByPrivateKey = encryptByPrivateKey(string.getBytes(), privateKeyStr);
			String encodeByPrivateKeyStr = Base64.encodeBase64String(encodeByPrivateKey);
			System.out.println("私钥加密：" + encodeByPrivateKeyStr);
			// 检验签名
			Boolean isSign = checkSignature(publicKeyStr, signStr, string.getBytes());
			System.out.println("jdkMD5-RSA签名检验：" + isSign);
			//
			byte[] decodeByPublicKey = decryptByPublicKey(encodeByPrivateKey, publicKeyStr);
			System.out.println("公钥解密：" + new String(decodeByPublicKey));
			//
			byte[] encodeByPublicKey = encryptByPublicKey(string.getBytes(), publicKeyStr);
			System.out.println("公钥加密：" + Base64.encodeBase64String(encodeByPublicKey));
			//
			byte[] decodeByByPrivateKey = decryptByPrivateKey(encodeByPublicKey, privateKeyStr);
			System.out.println("私钥解密：" + new String(decodeByByPrivateKey));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 检验签名
	 * 
	 * @param publicKey
	 * @param signBytes
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	private Boolean checkSignature(String publicKeyStr, String signStr, byte[] data) throws Exception {
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initVerify(publicK);
		signature.update(data);
		return signature.verify(Base64.decodeBase64(signStr));
	}

	/**
	 * 数据签名
	 * 
	 * @param privateKey
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private byte[] getSignature(String privateKeyStr, byte[] data) throws Exception {
		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		// 生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature sign = Signature.getInstance("MD5WithRSA");
		sign.initSign(privateKey);
		sign.update(data);
		return sign.sign();
	}

	/**
	 * 私钥加密
	 *
	 * @param data 待加密数据
	 * @param key  密钥
	 * @return byte[] 加密数据
	 */
	public byte[] encryptByPrivateKey(byte[] data, String privateKeyStr) throws Exception {
		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		// 生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}

	/**
	 * 公钥加密
	 *
	 * @param data 待加密数据
	 * @param key  密钥
	 * @return byte[] 加密数据
	 */
	public byte[] encryptByPublicKey(byte[] data, String publicKeyStr) throws Exception {
		// 实例化密钥工厂
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		// 初始化公钥
		// 密钥材料转换
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
		// 产生公钥
		PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
		// 数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		return cipher.doFinal(data);
	}

	/**
	 * 私钥解密
	 *
	 * @param data 待解密数据
	 * @param key  密钥
	 * @return byte[] 解密数据
	 */
	public byte[] decryptByPrivateKey(byte[] data, String privateKeyStr) throws Exception {
		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		// 生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}

	/**
	 * 公钥解密
	 *
	 * @param data 待解密数据
	 * @param key  密钥
	 * @return byte[] 解密数据
	 */
	public byte[] decryptByPublicKey(byte[] data, String publicKeyStr) throws Exception {
		// 实例化密钥工厂
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		// 初始化公钥
		// 密钥材料转换
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
		// 产生公钥
		PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
		// 数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, pubKey);
		return cipher.doFinal(data);
	}
}
