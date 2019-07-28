package com.sunrise.core.utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Spring web工具
 * 
 * @author Sun Rising
 * @date 2019.05.29 10:13:24
 *
 */
public class SpringWebUtils {

	/**
	 * 获取本次请求动作所携带的所有Request的参数
	 * 
	 * @author Sun Rising
	 * @date 2019.05.29 10:10:40
	 * @return
	 *
	 */
	public static Map<String, Object> getInterActionRequestsMap() {
		Map<String, Object> reqMap = new HashMap<String, Object>();
		// 获取HttpServletRequest
		HttpServletRequest request = getHttpServletRequest();
		// 获取URL携带的参数
		reqMap.putAll(RequestUtils.getUrlParams(request));
		// 获取form携带的参数
		reqMap.putAll(RequestUtils.getFormParams(request));
		// 获取JSON流携带的参数
		reqMap.putAll(RequestUtils.getJsonParams(request));
		return reqMap;
	}

	/**
	 * 获取本次请求的ServletRequestAttributes对象
	 * 
	 * @author Sun Rising
	 * @date 2019.06.17 11:47:02
	 * @return
	 *
	 */
	public static ServletRequestAttributes getServletRequestAttributes() {
		return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	}

	/**
	 * 获取本次请求的HttpServletRequest对象
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 02:50:51
	 * @return
	 *
	 */
	public static HttpServletRequest getHttpServletRequest() {
		ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
		return servletRequestAttributes.getRequest();
	}

	/**
	 * 获取本次请求的HttpServletResponse对象
	 * 
	 * @author Sun Rising
	 * @date 2019.06.16 02:50:51
	 * @return
	 *
	 */
	public static HttpServletResponse getHttpServletResponse() {
		ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
		return servletRequestAttributes.getResponse();
	}
}
