package com.sunrise.core.config.interceptor.imp;
//package com.sunrise.core.config.interceptor.imp;
//
//import java.util.Enumeration;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import com.sunrise.core.constant.SystemConst;
//import com.sunrise.core.utils.RequestUtils;
//import com.sunrise.core.utils.ThreadLocalUtils;
//
///**
// * 自定义拦截器
// * 
// * @author Sun_Rising
// * @date 2018.12.27 01:53:38
// *
// */
//@Component
//public class CustomInterceptor implements HandlerInterceptor {
//
//	/**
//	 * restApi请求开始，未到Controller 进行逻辑判断，如果ok就返回true，不行就返回false，返回false就不会处理该请求
//	 * 
//	 * @author Sun_Rising
//	 * @date 2018.12.27 01:53:51
//	 * @param request
//	 * @param response
//	 * @param handler
//	 * @return
//	 * @throws Exception
//	 *
//	 */
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		// 获取请求携带的get参数
//		Map<String, Object> contextParameter = RequestUtils.getUrlParams(request);
//		// 放入操作开始时间
//		contextParameter.put(SystemConst.OP_START_TIME.getValue(), System.currentTimeMillis());
//		// 放入线程共享内存中
//		ThreadLocalUtils.put(SystemConst.CONTEXT_PARAMETER.getValue(), contextParameter);
//		// 获取请求req携带的参数map
//		// map检验xss\sql注入
//		// 合法通过|不合法抛出异常
//		System.out.println("进入SpringBoot拦截器 - preHandle！");
//		System.out.println(request.getRequestURL());
//		System.out.println(request.getRequestURI());
//		System.out.println(request.getQueryString());
//		System.out.println(request.getMethod());
//		Enumeration<String> hE = request.getHeaderNames();
//		while (hE.hasMoreElements()) {
//			String tString = hE.nextElement();
//			System.out.println(tString);
//			System.out.println(request.getHeader(tString));
//		}
//		Enumeration<String> an = request.getParameterNames();
//		while (an.hasMoreElements()) {
//			String tString = an.nextElement();
//			System.out.println(tString);
//			System.out.println(request.getParameter(tString));
//		}
//		;
//		System.out.println(request.getAttributeNames());
//		// 符合规则直接放行
//		if (request.getRequestURI().indexOf("/anon") > -1) {
//			return true;
//		}
//		// 信息装配
//		return true;
//	}
//
//	/**
//	 * 
//	 * 处理请求完成后视图渲染之前的处理操作<br>
//	 * 如果Controller抛出异常则该方法不会执行
//	 * 
//	 * @author Sun_Rising
//	 * @date 2018.12.27 01:54:07
//	 * @param request
//	 * @param response
//	 * @param handler
//	 * @param modelAndView
//	 * @throws Exception
//	 *
//	 */
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		System.out.println("进入SpringBoot拦截器 - postHandle！");
//	}
//
//	/**
//	 * 视图渲染之后操作
//	 * 
//	 * @author Sun_Rising
//	 * @date 2018.12.27 01:54:37
//	 * @param request
//	 * @param response
//	 * @param handler
//	 * @param ex
//	 * @throws Exception
//	 *
//	 */
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		// 记录交互日志
//		System.out.println("进入SpringBoot拦截器 - afterCompletion！");
//	}
//}
