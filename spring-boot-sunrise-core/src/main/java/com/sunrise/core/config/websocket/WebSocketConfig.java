package com.sunrise.core.config.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websoket配置
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:10:00
 *
 */
@Configuration
public class WebSocketConfig {

	/**
	 * 启用长连接
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:10:14
	 * @return
	 *
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
