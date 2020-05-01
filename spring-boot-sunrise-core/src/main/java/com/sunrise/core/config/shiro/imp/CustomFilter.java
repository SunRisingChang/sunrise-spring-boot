package com.sunrise.core.config.shiro.imp;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.sunrise.core.config.advice.entity.HandleData;
import com.sunrise.core.config.advice.entity.ServiceResult;
import com.sunrise.core.constant.ExceptionConst;
import com.sunrise.core.utils.SpringContextUtils;

/**
 * shiro过滤器
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:04:50
 *
 */
public class CustomFilter extends AccessControlFilter {

	/**
	 * 即是否允许访问,返回true表示允许
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:05:02
	 * @param request
	 * @param response
	 * @param mappedValue
	 * @return
	 * @throws Exception
	 *
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// 判断是否登录
		if (!subject.isAuthenticated()) {
			HandleData handleData = new HandleData();
			handleData.setCode(ExceptionConst.SHIRO_CREDENTITALS.getCode());
			handleData.setMessage(ExceptionConst.SHIRO_CREDENTITALS.getMessage());
			ServiceResult serviceResult = new ServiceResult();
			serviceResult.setPath(httpServletRequest.getRequestURI());
			serviceResult.setTimestamp(System.currentTimeMillis());
			serviceResult.setStat(ExceptionConst.HTTP_OK.getCode());
			serviceResult.setMessage(ExceptionConst.HTTP_OK.getMessage());
			serviceResult.setHandle(handleData);
			response.setContentType("application/json;charset=utf-8");
			FastJsonConfig fastJsonConfig = SpringContextUtils.getBean("customFastJsonFormat");
			response.getWriter().println(JSON.toJSONString(serviceResult, fastJsonConfig.getSerializerFeatures()));
			return false;
		}
		return true;
	}

	/**
	 * 表示访问拒绝时是否自己处理，如果返回true表示自己不处理且继续拦截器链执行，返回false表示自己已经处理了
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:05:14
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return false;
	}
}
