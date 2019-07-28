package com.sunrise.config.encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 消息摘要算法主要分为3类：MD（Message Digest）、SHA（Secure Hash Algorithm）、MAC（Message
 * Authentication Code），以上3类算法的主要作用是验证数据的完整性——是数字签名的核心算法
 * 
 * 安全散列算法，固定长度的摘要信息。被认为是MD5的继承者。
 * 是一个系列，包括SHA-1(160)、SHA-2（SHA-224、SHA-256、SHA-384、SHA-512），
 * 也就是除了SHA-1，其他的4种都被称为是SHA-2
 * 
 * @author Sun_Rising
 *
 */
public class SHA {

	private String string = "你好，SHA!";

	public static void main(String[] args) {
		try {
			SHA sha = new SHA();
			sha.jdksha1();
			sha.jdksha224();
			sha.jdksha256();
			sha.jdksha384();
			sha.jdksha512();
			sha.ccsha512();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jdksha1() throws NoSuchAlgorithmException {
		// 获取信息摘要器
		MessageDigest messageDigest = MessageDigest.getInstance("SHA");
		// 进行数据的摘要处理
		byte[] shaBytes = messageDigest.digest(string.getBytes());
		// 利用第三方包将byte数组转化为16进制字符串
		System.out.println("jdkSHA-1:" + Hex.encodeHexString(shaBytes));
	}

	public void jdksha224() throws NoSuchAlgorithmException {
		// jdk本身不支持sha224算法，需要BC提供支持
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-224");
		byte[] shaBytes = messageDigest.digest(string.getBytes());
		System.out.println("jdkSHA-224:" + Hex.encodeHexString(shaBytes));
	}

	public void jdksha256() throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] shaBytes = messageDigest.digest(string.getBytes());
		System.out.println("jdkSHA-256:" + Hex.encodeHexString(shaBytes));
	}

	public void jdksha384() throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
		byte[] shaBytes = messageDigest.digest(string.getBytes());
		System.out.println("jdkSHA-384:" + Hex.encodeHexString(shaBytes));
	}

	public void jdksha512() throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
		byte[] shaBytes = messageDigest.digest(string.getBytes());
		System.out.println("jdkSHA-512:" + Hex.encodeHexString(shaBytes));
	}

	public void ccsha512() throws NoSuchAlgorithmException {
		MessageDigest messageDigest = DigestUtils.getSha512Digest();
		byte[] shaBytes = messageDigest.digest(string.getBytes());
		System.out.println("ccSHA-512:" + Hex.encodeHexString(shaBytes));
	}
}
