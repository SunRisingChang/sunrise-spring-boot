package com.sunrise.core.config.exception;

import com.sunrise.core.constant.ExceptionConst;

/**
 * 自定义异常类
 * 
 * @author Sun Rising
 * @date 2019.06.16 10:12:27
 *
 */
public class CustomRuntimeException extends RuntimeException {

	/**
	 * serialVersionUID type is long
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 10:12:21
	 **/
	private static final long serialVersionUID = -3365809384613162699L;

	// 错误代码
	private int code;

	/**
	 * 默认处理异常
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 12:50:15
	 * @param message
	 *
	 */
	public CustomRuntimeException(String message) {
		super(message);
		this.code = ExceptionConst.HTTP_HANDLE_EXCE.getCode();
	}

	/**
	 * 仅包含message, 没有cause, 也不记录栈异常, 性能最高
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 10:22:55
	 * @param message
	 *
	 */
	public CustomRuntimeException(int code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * 包含message和异常栈
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 10:29:15
	 * @param message
	 * @param e       导致此异常发生的父异常
	 *
	 */
	public CustomRuntimeException(int code, String message, Exception e) {
		super(message, e.getCause());
		this.code = code;
	}

	/**
	 * 包含message和cause, 会记录栈异常
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 10:32:05
	 * @param message
	 * @param e                  导致此异常发生的父异常
	 * @param writableStackTrace 表示是否生成栈追踪信息
	 *
	 */
	public CustomRuntimeException(int code, String message, Exception e, boolean writableStackTrace) {
		super(message, e.getCause(), false, writableStackTrace);
		this.code = code;
	}

	/**
	 * 获取完整的异常信息
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 10:37:31
	 * @return
	 *
	 */
	public String getFullMessage() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("[ ");
		stringBuffer.append(this.code);
		stringBuffer.append(" ] ");
		stringBuffer.append(super.getMessage());
//		String localizedMessage = super.getLocalizedMessage();
//		if (StringUtils.isNotBlank(localizedMessage)) {
//			stringBuffer.append(" , ");
//			stringBuffer.append(localizedMessage);
//		}
		return stringBuffer.toString();
	}

	public int getCode() {
		return code;
	}
}
