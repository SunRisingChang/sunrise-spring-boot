package com.sunrise.core.config.advice.entity;

import lombok.Data;

/**
 * 业务处理响应实体
 * 
 * @author Sun Rising
 * @date 2019.06.16 12:20:51
 *
 */
@Data
public class HandleData {

	// 业务返回代码
	private int code;

	// 业务返回数据
	private Object data;

	// 业务返回信息
	private String message;
}
