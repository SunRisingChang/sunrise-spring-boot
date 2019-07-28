package com.sunrise.core.config.websocket;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
import com.sunrise.core.config.websocket.imp.WebSoketService;
import lombok.extern.slf4j.Slf4j;

/**
 * 系统级通知
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:10:49
 *
 */
@ServerEndpoint("/socket/anon/systemMessage")
@Component
@Slf4j
public class SysWebSocket {

	private static final String key_prefix = "/socket/anon/systemMessage";

	/**
	 * 链接建立成功的回调
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:11:00
	 * @param session
	 *
	 */
	@OnOpen
	public void onOpen(Session session) {
		WebSoketService.putConnection(getKey(session.getId()), session);
		try {
			WebSoketService.sendMessage(getKey(session.getId()), "连接成功");
			log.info("[websoket]连接成功");
		} catch (IOException e) {
			log.error("[websoket]连接失败 - [" + e.getClass().getName() + "]-[" + this.getClass() + "]");
		}
	}

	/**
	 * 链接关闭的回调
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:11:12
	 * @param session
	 *
	 */
	@OnClose
	public void onClose(Session session) {
		WebSoketService.removeConnection(getKey(session.getId()));
	}

	/**
	 * 发生错误的回调
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:11:22
	 * @param session
	 * @param error
	 *
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		WebSoketService.removeConnection(getKey(session.getId()));
	}

	/**
	 * 获取存放的key
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:11:32
	 * @param sessionId
	 * @return
	 *
	 */
	public static String getKey(String sessionId) {
		return key_prefix + sessionId;
	}
}
