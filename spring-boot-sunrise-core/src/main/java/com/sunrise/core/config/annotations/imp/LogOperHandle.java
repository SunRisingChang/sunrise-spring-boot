package com.sunrise.core.config.annotations.imp;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.constant.ExceptionConst;
import com.sunrise.core.entitys.SysUser;
import com.sunrise.core.services.logs.OperLogService;
import com.sunrise.core.utils.RequestUtils;
import com.sunrise.core.utils.ResponseUtils;
import com.sunrise.core.utils.SpringWebUtils;

/**
 * 操作日志处理
 * 
 * @author Sun Rising
 * @date 2019.06.30 06:37:59
 *
 */
@Aspect
@Component
public class LogOperHandle {

	@Autowired
	private OperLogService operLogService;

	@Pointcut("@annotation(com.sunrise.core.config.annotations.LogOper)")
	public void annotationPointcut() {
	}

	@Around("annotationPointcut() && @annotation(logOper)")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, LogOper logOper) throws Throwable {
		Throwable throwable = null;
		Object result = null;
		// ------------------ 获取需要的对象 开始 ---------------
		com.sunrise.core.entitys.LogOper sysLogOper = new com.sunrise.core.entitys.LogOper();
		HttpServletRequest httpServletRequest = SpringWebUtils.getHttpServletRequest();
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		long startTime = System.currentTimeMillis();
		// ------------------ 获取需要的对象 结束 ---------------
		// ------------------ 装配 开始 ----------------------
		sysLogOper.setStartTime(startTime);
		sysLogOper.setUrlDesc(logOper.message());
		sysLogOper.setRespCode(ExceptionConst.HTTP_HANDLE_OK.getCode() + "");
		sysLogOper.setRespDesc(ExceptionConst.HTTP_HANDLE_OK.getMessage());
		if (httpServletRequest != null) {
			sysLogOper.setCliAdrr(RequestUtils.getProxyIpAddr(httpServletRequest));
			sysLogOper.setCliDesc(RequestUtils.getHeadersInfo(httpServletRequest).get("user-agent"));
			sysLogOper.setReqUrl(httpServletRequest.getRequestURI());
			sysLogOper.setSvrAdrr(ResponseUtils.getServerIP());
			sysLogOper.setSvrName(ResponseUtils.getServerName());
		}
		if (sysUser != null)
			sysLogOper.setOpUser(sysUser.getAcName());
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			throwable = e;
			sysLogOper.setRespCode(ExceptionConst.HTTP_HANDLE_EXCE.getCode() + "");
			sysLogOper.setRespDesc(ExceptionConst.HTTP_HANDLE_EXCE.getMessage());
			sysLogOper.setExecInfo(e.getMessage());
		}
		sysLogOper.setProcTime(System.currentTimeMillis() - startTime);
		// ------------------ 装配 结束 ----------------------
		operLogService.saveLogOper(sysLogOper);
		if (throwable != null)
			// 如果有异常需要手动抛出，让Controller增强器拦截到进行统一的异常处理
			throw throwable;
		return result;
	}
}
