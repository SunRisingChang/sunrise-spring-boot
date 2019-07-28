package com.sunrise.core.config.advice.entity;

import lombok.Data;

/**
 * 服务器响应实体
 * 
 * @author Sun_Rising
 * @date 2018.12.27 01:48:32
 *
 */
@Data
public class ServiceResult {

	// 业务处理响应实体
	private HandleData handle;

	// 服务器响应时间
	private Long timestamp;

	// 服务器响应状态
	private int stat;

	// 服务器异常信息
	private String error;

	// 服务器响应信息
	private String message;

	// 客户端请求路径
	private String path;
}
