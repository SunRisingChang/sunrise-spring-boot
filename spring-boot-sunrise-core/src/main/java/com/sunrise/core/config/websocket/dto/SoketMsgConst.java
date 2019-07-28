package com.sunrise.core.config.websocket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * SoketMessage常量
 * 
 * @author Sun Rising
 * @date 2019.07.01 04:21:25
 *
 */
@Getter
@AllArgsConstructor
public enum SoketMsgConst {
	DICT_CHANGE("101", "字典项修改");

	private String type;

	private String message;
}
