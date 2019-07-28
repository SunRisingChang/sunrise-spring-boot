package com.sunrise.core.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * Key创建工具
 * 
 * @author Sun Rising
 * @date 2019.05.30 12:02:32
 *
 */
public class KeyCreatUtils {

	/**
	 * 获取前缀为sessionID的key
	 * 
	 * @author Sun Rising
	 * @date 2019.05.30 12:08:16
	 * @param key
	 * @return
	 *
	 */
	public static String getPrefixKeyBySession(String key) {
		Session session = SecurityUtils.getSubject().getSession();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(session.getId().toString());
		stringBuffer.append("-");
		stringBuffer.append(key);
		return stringBuffer.toString();
	}
}
