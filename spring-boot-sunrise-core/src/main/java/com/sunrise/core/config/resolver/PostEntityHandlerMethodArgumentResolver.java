package com.sunrise.core.config.resolver;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;
import com.sunrise.core.config.resolver.iface.PostEntity;

/***
 * 自定参数解析器,可解析application/json和application/x-www-form-urlencoded
 * 
 * @author Sun Rising
 * @date 2019.06.15 06:51:56
 *
 */
public class PostEntityHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;

	private ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor;

	private static final String APPLICATION_JSON = "application/json";

	public PostEntityHandlerMethodArgumentResolver(RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor, ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor) {
		this.requestResponseBodyMethodProcessor = requestResponseBodyMethodProcessor;
		this.servletModelAttributeMethodProcessor = servletModelAttributeMethodProcessor;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return PostEntity.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		assert request != null : "PostEntity 解析器没有获取到 HttpServletRequest 对象";
		String contentType = request.getContentType();
		if (Pattern.matches(APPLICATION_JSON + ".*", contentType.toLowerCase())) {
			return requestResponseBodyMethodProcessor.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
		} else {
			return servletModelAttributeMethodProcessor.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
		}
	}
}
