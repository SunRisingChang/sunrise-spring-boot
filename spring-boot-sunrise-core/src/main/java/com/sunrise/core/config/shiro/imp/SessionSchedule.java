package com.sunrise.core.config.shiro.imp;

import java.io.IOException;
import java.util.Map;
import org.apache.shiro.session.ExpiredSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import com.sunrise.core.config.websocket.SysWebSocket;
import com.sunrise.core.config.websocket.dto.SoketMessage;
import com.sunrise.core.config.websocket.dto.SoketMsgConst;
import com.sunrise.core.config.websocket.imp.WebSoketService;
import lombok.extern.slf4j.Slf4j;

/**
 * session状态更新
 * 
 * @author Sun Rising
 * @date 2020.04.28 11:13:12
 *
 */
@Slf4j
@Component
public class SessionSchedule {

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

	@Value("${shiro.custom.sessionStatUpdate}")
	private boolean sessionStatUpdate;

	@Value("${shiro.custom.sessionStatUpdateDuration}")
	private int sessionStatUpdateDuration;

	@Bean
	public void updateSessionStat() {
		if (sessionStatUpdate)
			threadPoolTaskScheduler.scheduleAtFixedRate(new Runnable() {

				@Override
				public void run() {
					Map<String, Session> sessionMap = SessionService.getSessionMap();
					for (String sessionId : sessionMap.keySet()) {
						try {
							ValidatingSession validatingSession = (ValidatingSession) sessionMap.get(sessionId);
							validatingSession.validate();
						} catch (Exception e) {
							// session 过期
							if (e instanceof ExpiredSessionException) {
								SoketMessage soketMessage = new SoketMessage(SoketMsgConst.SESSION_EXPIRED);
								soketMessage.setValue("会话：" + sessionId + " 过期");
								soketMessage.setTimestamp(System.currentTimeMillis());
								try {
									WebSoketService.sendMessage(SysWebSocket.getKey(sessionId), soketMessage);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							SessionService.removeSession(sessionId);
						}
					}
					log.debug("存活会话数 --> " + sessionMap.size());
				}
			}, sessionStatUpdateDuration * 1000);
	}
}
