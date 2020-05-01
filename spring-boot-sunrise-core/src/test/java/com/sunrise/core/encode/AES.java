package com.sunrise.core.encode;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

public class AES {

	private String string = "你好，AES!";

	public static void main(String[] args) {
		AES aes = new AES();
		aes.jdkAES();
	}

	public void jdkAES() {
		try {
			// 生成Key
			// KeyGenerator 提供对称密钥生成器的功能，支持各种算法
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
//			keyGenerator.init(128, new SecureRandom("seedseedseed".getBytes()));
			// 使用上面这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
			// SecretKey 负责保存对称密钥
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			System.out.println("jdkAES密钥 : " + Hex.encodeHexString(keyBytes));
			// Key转换
			Key key = new SecretKeySpec(keyBytes, "AES");
			// 加密
			// Cipher负责完成加密或解密工作
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encodeResult = cipher.doFinal(string.getBytes());
			System.out.println("jdkAES加密 : " + Hex.encodeHexString(encodeResult));
			// 解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decodeResult = cipher.doFinal(encodeResult);
			System.out.println("jdkAES解密 : " + new String(decodeResult));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
