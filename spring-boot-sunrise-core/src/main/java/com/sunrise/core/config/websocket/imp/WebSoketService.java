package com.sunrise.core.config.websocket.imp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.Session;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

/**
 * websoket连接管理
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:06:39
 *
 */
@Component
public class WebSoketService {

	// 连接对象存放容器<string:url-sessionID>
	private static Map<String, Session> webSocketMap = new HashMap<String, Session>();

	/**
	 * 移除连接
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:08:07
	 * @param key
	 *
	 */
	public static void removeConnection(String key) {
		if (webSocketMap.containsKey(key)) {
			webSocketMap.remove(key);
		}
	}

	/**
	 * 存入链接
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:08:27
	 * @param key
	 * @param session
	 *
	 */
	public static void putConnection(String key, Session session) {
		webSocketMap.put(key, session);
	}

	/**
	 * 通过key获取长连接对象
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:08:57
	 * @param key
	 * @return
	 *
	 */
	public static Session getWebSoketBySid(String key) {
		if (webSocketMap.containsKey(key)) {
			return webSocketMap.get(key);
		}
		return null;
	}

	/**
	 * 指定长连接推送消息
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:09:30
	 * @param key
	 * @param message
	 * @throws IOException
	 *
	 */
	public static void sendMessage(String key, Object message) throws IOException {
		if (webSocketMap.containsKey(key)) {
			webSocketMap.get(key).getBasicRemote().sendText(JSON.toJSONString(message));
		}
	}

	/**
	 * 广播通知所有的长连接
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:09:40
	 * @param message
	 * @throws IOException
	 *
	 */
	public static void allSendMessage(Object message) throws IOException {
		for (String key : webSocketMap.keySet()) {
			WebSoketService.sendMessage(key, message);
		}
	}
}
