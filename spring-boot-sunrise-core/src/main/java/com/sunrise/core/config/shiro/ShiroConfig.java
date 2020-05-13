package com.sunrise.core.config.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.Filter;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sunrise.core.config.shiro.imp.CustomFilter;
import com.sunrise.core.config.shiro.imp.CustomRealm;
import com.sunrise.core.config.shiro.imp.CustomSessionListener;

/**
 * Shiro核心配置类
 * 
 * @author Sun_Rising
 * @date 2018.12.27 01:58:00
 *
 */
@Configuration
public class ShiroConfig {

	/**
	 * 声明域验证器
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:04:28
	 * @return
	 *
	 */
	@Bean
	public Realm realm() {
		return new CustomRealm();
	}

	/**
	 * 声明拦截器
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:04:20
	 * @return
	 *
	 */
	@Bean
	public Map<String, Filter> shiroFilters() {
		Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
		filters.put("customFilter", new CustomFilter());
		return filters;
	}

	/**
	 * 声明URL拦截器链
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:04:11
	 * @return
	 *
	 */
	@Bean
	public Map<String, String> filterChainDefinitionMap() {
		Map<String, String> chainMap = new LinkedHashMap<String, String>();
		chainMap.put("/**/anon/**", "anon");
		chainMap.put("/**", "customFilter");
		return chainMap;
	}

	/**
	 * 引用URL拦截器链、拦截器，切入shiro主体
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:04:02
	 * @return
	 *
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactory() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		shiroFilterFactoryBean.getFilters().putAll(shiroFilters());
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap());
		return shiroFilterFactoryBean;
	}

	/**
	 * session监听器
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:55:35
	 * @return
	 *
	 */
	@Bean
	public Collection<SessionListener> sessionListeners() {
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		listeners.add(new CustomSessionListener());
		return listeners;
	}

	/**
	 * session管理器
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:43:51
	 * @return
	 *
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		// 设置session过期时间3600s-3600000L
		sessionManager.setGlobalSessionTimeout(1800000L);
		sessionManager.setSessionListeners(sessionListeners());
		return sessionManager;
	}

	/**
	 * 初始化shiro主体，引用域验证器
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:03:53
	 * @return
	 *
	 */
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(realm());
		defaultWebSecurityManager.setSessionManager(sessionManager());
		return defaultWebSecurityManager;
	}

	/**
	 * setProxyTargetClass(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
	 * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
	 * 在@Controller注解的类的方法中加入@Autowired注解，会导致无法注入。 加入这项配置能解决这个bug
	 * spring.aop.proxy-target-class=false true为使用CGLIB代理，false为JDK代理，默认为false
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:58:18
	 * @return
	 *
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}
}
