package com.sunrise.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务处理异常 常量
 * 
 * @author Sun Rising
 * @date 2019.06.16 02:27:44
 *
 */
@Getter
@AllArgsConstructor
public enum ExceptionConst {
	SHIRO_CREDENTITALS(4010, "请求要求进行身份验证"),
	SHIRO_UNKNOWN_ACCOUNT(4011, "未知的账号"),
	SHIRO_INCORRECT_CREDENTIALS(4012, "不正确的凭证"),
	SHIRO_EXPIRED_CREDENTIALS(4013, "凭证过期"),
	SHIRO_EXCESSIVE_ATTEMPTS(4014, "认证次数超过限制"),
	SHIRO_LOCKED_ACCOUNT(4015, "账号被锁定"),
	SHIRO_CONCURRENT_ACCESS(4016, "并发访问异常"),
	SHIRO_DISABLED_ACCOUNT(4017, "注销的账号"),
	SHIRO_UNSUPPORTED_TOKEN(4018, "未知的Token"),
	SHIRO_ACCOUNT(4019, "账户异常"),
	HTTP_OK(200, "服务器已成功响应"),
	HTTP_HANDLE_OK(200, "请求处理成功"),
	HTTP_HANDLE_EXCE(777, "请求处理异常"),
	HTTP_ERROR(500, "服务器异常"),
	HTTP_NOHANDLER_FOUND(404, "请求的资源不可用"),
	HTTP_NO_FOUND_PARAMS(405, "请求参数异常");

	private int code;

	private String message;
}
