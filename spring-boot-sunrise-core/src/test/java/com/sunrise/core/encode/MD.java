package com.sunrise.core.encode;

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
 * MD算法家族有3类MD2、MD4、MD5，MD家族生成的都是128位的信息摘要
 * 
 * @author Sun_Rising
 *
 */
public class MD {

	private String string = "你好，MD!";

	public static void main(String[] args) {
		MD mainTest = new MD();
		mainTest.jdkMd5();
		mainTest.jdkMd4();
		mainTest.jdkMd2();
		mainTest.ccMd5();
		mainTest.ccMd2();
	}

	public void jdkMd5() {
		try {
			// 获取MD5类型的信息摘要器
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// digest()信息摘要,内部先执行了update()之后执行了digest()
			byte[] md5Bytes = messageDigest.digest(string.getBytes());
			// 利用第三方包将byte数组转化为16进制字符串
			System.out.println("jdkMd5:" + Hex.encodeHexString(md5Bytes));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void jdkMd4() {
		try {
			// 因为jdk自身没有提供MD4的算法，所以要使用bc包提供算法支持
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest messageDigest = MessageDigest.getInstance("MD4");
			byte[] md4Bytes = messageDigest.digest(string.getBytes());
			System.out.println("jdkMd4:" + Hex.encodeHexString(md4Bytes));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void jdkMd2() {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD2");
			byte[] md2Bytes = messageDigest.digest(string.getBytes());
			System.out.println("jdkMd2:" + Hex.encodeHexString(md2Bytes));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void ccMd5() {
		MessageDigest messageDigest = DigestUtils.getMd5Digest();
		byte[] md5Bytes = messageDigest.digest(string.getBytes());
		System.out.println("ccMd5:" + Hex.encodeHexString(md5Bytes));
	}

	public void ccMd2() {
		MessageDigest messageDigest = DigestUtils.getMd2Digest();
		byte[] md2Bytes = messageDigest.digest(string.getBytes());
		System.out.println("ccMd2:" + Hex.encodeHexString(md2Bytes));
	}
}
