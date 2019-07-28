package com.sunrise.core.config.websocket.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 长连接通知对象
 * 
 * @author Sun Rising
 * @date 2019.07.01 04:08:41
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SoketMessage {

	// 消息类型
	private String type;

	// 消息信息体
	private String value;

	// 消息说明
	private String message;

	// 时间戳
	private Long timestamp;

	public SoketMessage(SoketMsgConst soketMessageConst) {
		this.type = soketMessageConst.getType();
		this.message = soketMessageConst.getMessage();
	}
}
