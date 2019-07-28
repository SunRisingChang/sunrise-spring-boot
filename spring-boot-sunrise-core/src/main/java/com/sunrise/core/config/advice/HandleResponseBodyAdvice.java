package com.sunrise.core.config.advice;

import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import com.sunrise.core.config.advice.entity.HandleData;
import com.sunrise.core.config.advice.entity.ServiceResult;
import com.sunrise.core.constant.ExceptionConst;

/**
 * API访问统一处理类，Controller增强器
 * 
 * @author Sun_Rising
 * @date 2018.12.27 01:48:56
 *
 */
@ControllerAdvice
public class HandleResponseBodyAdvice implements ResponseBodyAdvice<Object> {

	/**
	 * 重写Controller返回对象
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:49:13
	 * @param body
	 * @param returnType
	 * @param selectedContentType
	 * @param selectedConverterType
	 * @param request
	 * @param response
	 * @return
	 *
	 */
	@Override
	public ServiceResult beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if (body instanceof ServiceResult) {
			return (ServiceResult) body;
		}
		HandleData handleData = new HandleData();
		handleData.setData(body);
		handleData.setCode(ExceptionConst.HTTP_HANDLE_OK.getCode());
		handleData.setMessage(ExceptionConst.HTTP_HANDLE_OK.getMessage());
		ServiceResult serviceResult = new ServiceResult();
		serviceResult.setPath(request.getURI().getPath());
		serviceResult.setTimestamp(System.currentTimeMillis());
		serviceResult.setStat(ExceptionConst.HTTP_OK.getCode());
		serviceResult.setMessage(ExceptionConst.HTTP_OK.getMessage());
		serviceResult.setHandle(handleData);
		return serviceResult;
	}

	/**
	 * 哪些请求进行重写Controller返回对象
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:49:48
	 * @param returnType
	 * @param converterType
	 * @return
	 *
	 */
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	/**
	 * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:50:01
	 * @param request
	 * @param model
	 *
	 */
	@ModelAttribute
	public void addAttributes(HttpServletRequest request, Model model) {
		// 可用于在到达Controller之前放入必要的数据
		// model.addAttribute("author", "Magical Sam");
	}

	/**
	 * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:50:13
	 * @param binder
	 *
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 用于表单数据的特殊处理
		// <input type="text" name="user.id" value="huo_user_id">
		// binder.setFieldDefaultPrefix("user.");
	}
}