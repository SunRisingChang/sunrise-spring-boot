package com.sunrise.core.config.shiro.imp;

import java.util.HashMap;
import java.util.Map;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Component;
import lombok.Getter;

/**
 * Session会话存储
 * 
 * @author Sun Rising
 * @date 2020.04.28 12:46:27
 *
 */
@Component
public class SessionService {

	// 会话对象存放容器<string:sessionID>
	private @Getter static Map<String, Session> sessionMap = new HashMap<String, Session>();

	/**
	 * 移除会话
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:08:07
	 * @param sessionId
	 *
	 */
	public static void removeSession(String sessionId) {
		if (sessionMap.containsKey(sessionId)) {
			sessionMap.remove(sessionId);
		}
	}

	/**
	 * 存入会话
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:08:27
	 * @param key
	 * @param session
	 *
	 */
	public static void putSession(Session session) {
		sessionMap.put(session.getId().toString(), session);
	}

	/**
	 * 通过sessionId获取会话
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:08:57
	 * @param key
	 * @return
	 *
	 */
	public static Session getSessionById(String sessionId) {
		if (sessionMap.containsKey(sessionId)) {
			return sessionMap.get(sessionId);
		}
		return null;
	}
}
