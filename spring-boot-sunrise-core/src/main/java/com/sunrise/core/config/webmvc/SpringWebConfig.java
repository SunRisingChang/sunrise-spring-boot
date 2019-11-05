package com.sunrise.core.config.webmvc;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sunrise.core.config.resolver.PostEntityHandlerMethodArgumentResolver;

/**
 * spring web 统一配置
 * 
 * @author Sun Rising
 * @date 2019.06.15 06:42:29
 *
 */
@Configuration
@EnableWebMvc
public class SpringWebConfig implements WebMvcConfigurer {

	@Autowired
	private FastJsonConfig customFastJsonFormat;

	@Autowired
	private List<MediaType> customFastJsonMediaTypes;

	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

	/**
	 * 配置跨域
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:51:06
	 * 
	 */
	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*"); // 允许任何域名使用
		corsConfiguration.addAllowedHeader("*"); // 允许任何头
		corsConfiguration.addAllowedMethod("*"); // 允许任何方法
		corsConfiguration.setMaxAge(18000L); // 预检请求的有效期，单位为秒。
		corsConfiguration.setAllowCredentials(true);// 是否支持安全证书(必需参数)
		return corsConfiguration;
	}

	/**
	 * 使用跨域
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:51:06
	 * 
	 */
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(source));
		filterRegistrationBean.setOrder(0);// 设置监听器的优先级
		return filterRegistrationBean;
	}

	/**
	 * 添加FastjsonHTTP信息转换器
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:51:06
	 * @param converters
	 *
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		fastJsonHttpMessageConverter.setSupportedMediaTypes(customFastJsonMediaTypes);
		fastJsonHttpMessageConverter.setFastJsonConfig(customFastJsonFormat);
		converters.add(fastJsonHttpMessageConverter);
	}

	/**
	 * 添加自定参数解析器,可解析application/json和application/x-www-form-urlencoded
	 * 重写addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers)不生效
	 * 
	 * @author Sun Rising
	 * @date 2019.06.15 09:24:10
	 *
	 */
	@PostConstruct
	public void addArgumentResolvers() {
		RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor = null;
		ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor = null;
		List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
		for (HandlerMethodArgumentResolver argumentResolver : argumentResolvers) {
			if (argumentResolver instanceof ServletModelAttributeMethodProcessor) {
				servletModelAttributeMethodProcessor = (ServletModelAttributeMethodProcessor) argumentResolver;
			} else if (argumentResolver instanceof RequestResponseBodyMethodProcessor) {
				requestResponseBodyMethodProcessor = (RequestResponseBodyMethodProcessor) argumentResolver;
			}
			if (servletModelAttributeMethodProcessor != null && requestResponseBodyMethodProcessor != null) {
				break;
			}
		}
		PostEntityHandlerMethodArgumentResolver postEntityHandlerMethodArgumentResolver = new PostEntityHandlerMethodArgumentResolver(
				requestResponseBodyMethodProcessor, servletModelAttributeMethodProcessor);
		List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(argumentResolvers.size() + 1);
		newResolvers.add(postEntityHandlerMethodArgumentResolver);
		newResolvers.addAll(argumentResolvers);
		requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);
	}
}
