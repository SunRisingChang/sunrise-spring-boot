package com.sunrise.config.encode;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Hex;

/**
 * DES是一种基于56位密钥的对称算法，1976年被美国联邦政府的国家标准局确定为联邦资料处理标准（FIPS），
 * 随后在国际上广泛流传开来。现在DES已经不是一种安全的加密算法，已被公开破解， 现在DES已经被高级加密标准（AES）所代替。
 * 
 * @author Sun_Rising
 *
 */
public class DES {

	private String string = "你好，DES！";

	public static void main(String[] args) {
		DES des = new DES();
		des.jdkDES();
		des.jdk3DES();
	}

	public void jdkDES() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			System.out.println("jdkDES密钥 :" + Hex.encodeHexString(bytesKey));
			// KEY转换
			DESKeySpec deSedeKeySpec = new DESKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			Key convertSecretKey = factory.generateSecret(deSedeKeySpec);
			// 加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] encodeResult = cipher.doFinal(string.getBytes());
			System.out.println("jdkDES加密 :" + Hex.encodeHexString(encodeResult));
			// 解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			byte[] DecodeResult = cipher.doFinal(encodeResult);
			System.out.println("jdkDES解密 :" + new String(DecodeResult));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void jdk3DES() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
			keyGenerator.init(168);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			System.out.println("jdk3DES密钥 :" + Hex.encodeHexString(bytesKey));
			// KEY转换
			DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
			Key convertSecretKey = factory.generateSecret(deSedeKeySpec);
			// 加密
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] encodeResult = cipher.doFinal(string.getBytes());
			System.out.println("jdk3DES加密 :" + Hex.encodeHexString(encodeResult));
			// 解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			byte[] DecodeResult = cipher.doFinal(encodeResult);
			System.out.println("jdk3DES解密 :" + new String(DecodeResult));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
