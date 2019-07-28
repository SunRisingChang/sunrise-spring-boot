package com.sunrise.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 文件工具
 * 
 * @author Sun Rising
 * @date 2019.07.09 09:38:52
 *
 */
public class FileUtils {

	/**
	 * 获取文件的MD5
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 09:38:37
	 * @param file
	 * @return
	 *
	 */
	public static String fileMD5(File file) {
		try (FileInputStream fis = new FileInputStream(file)) {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = fis.read(buffer, 0, 1024)) != -1) {
				md.update(buffer, 0, length);
			}
			BigInteger bigInt = new BigInteger(1, md.digest());
			return bigInt.toString(16);
		} catch (Exception e) {
			return null;
		}
	}
}
