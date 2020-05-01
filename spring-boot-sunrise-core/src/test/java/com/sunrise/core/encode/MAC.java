package com.sunrise.core.encode;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

/**
 * 消息摘要算法主要分为3类：MD（Message Digest）、SHA（Secure Hash Algorithm）、MAC（Message
 * Authentication Code），以上3类算法的主要作用是验证数据的完整性——是数字签名的核心算法
 * 
 * MAC(Message Authentication Code)，兼容了MD和SHA的特性，并且在它们的基础上加入了密钥。
 * 因此MAC也称为HMAC（keyed-Hash Message Authentication Code）含有密钥的散列函数算法
 * 
 * MD系列：HmacMD2、HmacMD4、HmacMD5
 * SHA系列：HmacSHA1、HmacSHA224、HmacSHA256、HmacSHA384、HmacSHA512
 * 
 * @author Sun_Rising
 *
 */
public class MAC {

	private String string = "你好，MAC!";

	public static void main(String[] args) {
		try {
			MAC mac = new MAC();
			mac.jdkHmacMD5();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jdkHmacMD5() throws Exception {
		// -----------------使用自定义的密钥 开始---------------------
		// 自定义密钥(必须是偶数,16进制字符)
		byte[] diyKeyBytes = Hex.decodeHex("aaaaaa".toCharArray());
		// 还原密钥
		SecretKey secretKey = new SecretKeySpec(diyKeyBytes, "hmacMD5");
		// 获取密钥的byte数组
		byte[] key = secretKey.getEncoded();
		System.out.println("jdkHmacMD5密钥：" + Hex.encodeHexString(key));
		// -----------------使用自定义的密钥 结束---------------------
		// -----------------使用生成器的密钥 开始---------------------
//		// 获取密钥生成器
//		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
//		// 获取密钥
//		SecretKey secretKey = keyGenerator.generateKey();
//		// 获取密钥的byte数组
//		byte[] key = secretKey.getEncoded();
//		System.out.println("jdkHmacMD5密钥：" + Hex.encodeHexString(key));
		// -----------------使用生成器的密钥 结束---------------------
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		byte[] macbytes = mac.doFinal(string.getBytes());
		System.out.println("jdkHmacMD5摘要：" + Hex.encodeHexString(macbytes));
	}
}
