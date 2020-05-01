package com.sunrise.core.config.websocket.imp;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

/**
 * 继承websocket配置类，将httpsession放入ServerEndpointConfig的map中
 * 从而达到使websocket对象可以访问到httpsession中的对象
 * 
 * @author Sun Rising
 * @date 2020.04.28 09:36:35
 *
 */
public class GetHttpSessionConfigurator extends Configurator {

	/**
	 * 重写修改握手方法
	 * 
	 * @author Sun Rising
	 * @date 2020.04.28 09:37:58
	 * @param sec
	 * @param request
	 * @param response
	 *
	 */
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		HttpSession httpSession = (HttpSession) request.getHttpSession();
		sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
	}
}
