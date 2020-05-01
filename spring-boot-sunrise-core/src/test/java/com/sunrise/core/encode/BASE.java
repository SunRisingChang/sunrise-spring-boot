package com.sunrise.core.encode;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64编码
 * 
 * @author Sun_Rising
 *
 */
public class BASE {

	private String string = "你好，BEASE64!";

	public static void main(String[] args) {
		BASE base64 = new BASE();
		base64.jdkBase64();
		base64.ccBase64();
	}

	public void jdkBase64() {
		String enbase64Str = java.util.Base64.getEncoder().encodeToString(string.getBytes());
		System.out.println("jdkBase64编码:" + enbase64Str);
		//
		byte[] debase64Bytes = java.util.Base64.getDecoder().decode(enbase64Str);
		System.out.println("jdkBase64解码:" + new String(debase64Bytes));
	}

	public void ccBase64() {
		byte[] base64enBytes = Base64.encodeBase64(string.getBytes());
		String base64enString = new String(base64enBytes);
		System.out.println("ccBase64编码:" + base64enString);
		//
		byte[] base64decBytes = Base64.decodeBase64(new String(base64enString));
		String base64decString = new String(base64decBytes);
		System.out.println("ccBase64解码:" + base64decString);
	}
}
