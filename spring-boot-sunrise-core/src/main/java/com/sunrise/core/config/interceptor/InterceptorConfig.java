package com.sunrise.core.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * 
 * @author Sun_Rising
 * @date 2018.12.27 01:52:04
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//	@Autowired
//	private SysInterceptor sysInterceptor;
	/**
	 * 配置静态资源,避免静态资源请求被拦截
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:52:26
	 * @param registry
	 *
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
	}

	/**
	 * 添加拦截器<br>
	 * addPathPatterns 用于添加拦截规则<br>
	 * excludePathPatterns 用于排除拦截
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:52:39
	 * @param registry
	 *
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(sysInterceptor).addPathPatterns("/**");
	}
}
