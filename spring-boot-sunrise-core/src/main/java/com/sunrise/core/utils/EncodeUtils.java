package com.sunrise.core.utils;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 数据加密类
 * 
 * @author Sun Rising
 * @date 2020.04.29 01:46:44
 *
 */
public class EncodeUtils {

	/**
	 * 对字符串进行MD5
	 * 
	 * @author Sun Rising
	 * @date 2020.04.29 01:57:12
	 * @param string
	 * @return
	 *
	 */
	public static String MD5(String string) {
		MessageDigest messageDigest = DigestUtils.getMd5Digest();
		byte[] md5Bytes = messageDigest.digest(string.getBytes());
		return Hex.encodeHexString(md5Bytes);
	}

	/**
	 * 创建密码
	 * 
	 * @author Sun Rising
	 * @date 2020.04.29 02:45:41
	 * @param string 密码明文->MD5(Hex(SHA256(明文)))
	 * @return
	 *
	 */
	public static String createPasswd(String string) {
		try {
			byte[] sha256Bytes = MessageDigest.getInstance("SHA-256").digest(string.getBytes());
			String SHA256_HEX = Hex.encodeHexString(sha256Bytes);
			return EncodeUtils.MD5(SHA256_HEX);
		} catch (Exception e) {
		}
		return string;
	}
}
