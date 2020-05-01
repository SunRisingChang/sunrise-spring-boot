package com.sunrise.core.config.shiro.imp;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * session监听器
 * 
 * @author Sun Rising
 * @date 2019.07.06 10:00:33
 *
 */
public class CustomSessionListener implements SessionListener {

	/**
	 * 会话创建时触发
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:51:21
	 * @param session
	 *
	 */
	@Override
	public void onStart(Session session) {
		SessionService.putSession(session);
	}

	/**
	 * 退出会话时触发
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:51:34
	 * @param session
	 *
	 */
	@Override
	public void onStop(Session session) {
		SessionService.removeSession(session.getId().toString());
	}

	/**
	 * 会话过期时触发
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:51:46
	 * @param session
	 *
	 */
	@Override
	public void onExpiration(Session session) {
		SessionService.removeSession(session.getId().toString());
	}
}
