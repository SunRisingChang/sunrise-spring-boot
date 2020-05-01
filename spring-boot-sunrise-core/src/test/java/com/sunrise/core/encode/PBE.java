package com.sunrise.core.encode;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 对称加密算法
 * 
 * PBE——Password-based encryption（基于密码加密）。 其特点在于口令由用户自己掌管，不借助任何物理媒体；
 * 采用随机数（这里我们叫做盐）杂凑多重加密等方法保证数据的安全性。 是一种简便的加密方式
 * 
 * @author Sun_Rising
 *
 */
public class PBE {

	private String string = "你好，PBE!";

	public static void main(String[] args) {
		try {
			PBE pbe = new PBE();
			pbe.jdkPBE();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jdkPBE() throws Exception {
		// 初始化盐
		SecureRandom random = new SecureRandom();
		byte[] salt = random.generateSeed(8);
		// 必须是8位
//		byte[] salt = "aabbccdd".getBytes();
		System.out.println("PBE随机盐：" + Hex.encodeHexString(salt));
		// 口令与密钥
		String password = "cakin24";
		System.out.println("PBE口令：" + password);
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
		SecretKey key = factory.generateSecret(pbeKeySpec);
		// 加密
		// 100迭代次数
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
		Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
		cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
		byte[] result = cipher.doFinal(string.getBytes());
		System.out.println("PBE加密: " + Base64.encodeBase64String(result));
		// 解密
		cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
		result = cipher.doFinal(result);
		System.out.println("PBE解密 : " + new String(result));
	}
}
