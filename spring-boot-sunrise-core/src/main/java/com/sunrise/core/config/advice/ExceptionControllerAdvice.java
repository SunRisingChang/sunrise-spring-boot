package com.sunrise.core.config.advice;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.sunrise.core.config.advice.entity.HandleData;
import com.sunrise.core.config.advice.entity.ServiceResult;
import com.sunrise.core.config.exception.CustomRuntimeException;
import com.sunrise.core.constant.ExceptionConst;
import com.sunrise.core.utils.SpringWebUtils;

/**
 * 统一异常处理器
 * 
 * @author Sun Rising
 * @date 2019.06.16 10:41:19
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

	/**
	 * 业务异常
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 12:35:52
	 * @param e 自定义异常类CustomRuntimeException
	 * @return
	 *
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = { CustomRuntimeException.class, ShiroException.class })
	public ServiceResult handleCustomRuntimeException(Exception e) {
		HandleData handleData = new HandleData();
		if (e instanceof CustomRuntimeException) {
			CustomRuntimeException customRuntimeException = (CustomRuntimeException) e;
			handleData.setCode(customRuntimeException.getCode());
			handleData.setMessage(customRuntimeException.getMessage());
		} else if (e instanceof ShiroException) {
			if (e instanceof UnknownAccountException) {
				handleData.setCode(ExceptionConst.SHIRO_UNKNOWN_ACCOUNT.getCode());
				handleData.setMessage(ExceptionConst.SHIRO_UNKNOWN_ACCOUNT.getMessage());
			} else if (e instanceof IncorrectCredentialsException) {
				handleData.setCode(ExceptionConst.SHIRO_INCORRECT_CREDENTIALS.getCode());
				handleData.setMessage(e.getMessage());
			} else if (e instanceof ExpiredCredentialsException) {
				handleData.setCode(ExceptionConst.SHIRO_EXPIRED_CREDENTIALS.getCode());
				handleData.setMessage(ExceptionConst.SHIRO_EXPIRED_CREDENTIALS.getMessage());
			} else if (e instanceof ExcessiveAttemptsException) {
				handleData.setCode(ExceptionConst.SHIRO_EXCESSIVE_ATTEMPTS.getCode());
				handleData.setMessage(e.getMessage());
			} else if (e instanceof LockedAccountException) {
				handleData.setCode(ExceptionConst.SHIRO_LOCKED_ACCOUNT.getCode());
				handleData.setMessage(ExceptionConst.SHIRO_LOCKED_ACCOUNT.getMessage());
			} else if (e instanceof ConcurrentAccessException) {
				handleData.setCode(ExceptionConst.SHIRO_CONCURRENT_ACCESS.getCode());
				handleData.setMessage(ExceptionConst.SHIRO_CONCURRENT_ACCESS.getMessage());
			} else if (e instanceof DisabledAccountException) {
				handleData.setCode(ExceptionConst.SHIRO_DISABLED_ACCOUNT.getCode());
				handleData.setMessage(ExceptionConst.SHIRO_DISABLED_ACCOUNT.getMessage());
			} else if (e instanceof UnsupportedTokenException) {
				handleData.setCode(ExceptionConst.SHIRO_UNSUPPORTED_TOKEN.getCode());
				handleData.setMessage(ExceptionConst.SHIRO_UNSUPPORTED_TOKEN.getMessage());
			} else {
				handleData.setCode(ExceptionConst.SHIRO_ACCOUNT.getCode());
				handleData.setMessage(ExceptionConst.SHIRO_ACCOUNT.getMessage());
			}
		}
		ServiceResult serviceResult = new ServiceResult();
		serviceResult.setPath(SpringWebUtils.getHttpServletRequest().getRequestURI());
		serviceResult.setTimestamp(System.currentTimeMillis());
		serviceResult.setStat(ExceptionConst.HTTP_OK.getCode());
		serviceResult.setMessage(ExceptionConst.HTTP_OK.getMessage());
		serviceResult.setHandle(handleData);
		return serviceResult;
	}

	/**
	 * 服务器异常
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 12:36:50
	 * @param e 异常对象Exception
	 * @return
	 *
	 */
	@ResponseBody
	@ExceptionHandler(Throwable.class)
	public ServiceResult handleSystemException(Throwable e) {
		ServiceResult serviceResult = new ServiceResult();
		serviceResult.setPath(SpringWebUtils.getHttpServletRequest().getRequestURI());
		serviceResult.setTimestamp(System.currentTimeMillis());
		serviceResult.setError(e.getMessage());
		serviceResult.setMessage(ExceptionConst.HTTP_ERROR.getMessage());
		if (e instanceof NoHandlerFoundException) {// 404
			SpringWebUtils.getHttpServletResponse().setStatus(ExceptionConst.HTTP_NOHANDLER_FOUND.getCode());
			serviceResult.setStat(ExceptionConst.HTTP_NOHANDLER_FOUND.getCode());
		} else {
			SpringWebUtils.getHttpServletResponse().setStatus(ExceptionConst.HTTP_ERROR.getCode());
			serviceResult.setStat(ExceptionConst.HTTP_ERROR.getCode());
		}
		e.printStackTrace();
		return serviceResult;
	}
}
