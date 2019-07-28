package com.sunrise.core.utils;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring Boot 上下文工具类
 * 
 * @author Sun Rising
 * @date 2018.12.25 09:11:21
 *
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	private static final Logger logger = LoggerFactory.getLogger(SpringContextUtils.class);

	/**
	 * 初始化 ApplicationContext
	 * 
	 * @author Sun Rising
	 * @date 2018.12.29 05:25:44
	 * @param applicationContext
	 * @throws BeansException
	 *
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtils.applicationContext = applicationContext;
	}

	/**
	 * 获取 ApplicationContext
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:44:44
	 * @return
	 *
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 从静态变量applicationContext中得到Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:26:40
	 * @param beanName 类名称
	 * @return 类实例
	 *
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		try {
			if (applicationContext != null)
				return (T) applicationContext.getBean(beanName);
		} catch (BeansException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/**
	 * 从静态变量applicationContext中得到Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:28:46
	 * @param clazz 类型类
	 * @return 类实例
	 *
	 */
	public static <T> T getBean(Class<T> clazz) {
		try {
			if (applicationContext != null)
				return applicationContext.getBean(clazz);
		} catch (BeansException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/**
	 * 通过 类型类 获取类集合
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:47:39
	 * @param clazz 类型类
	 * @return 类集合
	 *
	 */
	public static <T> Map<String, T> getBeans(Class<T> clazz) {
		try {
			if (applicationContext != null)
				return applicationContext.getBeansOfType(clazz);
		} catch (BeansException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/**
	 * 通过 类型类 获取类名称集合
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:52:06
	 * @param clazz 类型类
	 * @return 类名称集合
	 *
	 */
	public static String[] getBeansName(Class<?> clazz) {
		try {
			if (applicationContext != null)
				return applicationContext.getBeanNamesForType(clazz);
		} catch (BeansException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/**
	 * 从静态变量applicationContext中得到Bean
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:33:54
	 * @param classFullName 类全路径，例com.mysql.jdbc.Driver
	 * @return 类实例
	 *
	 */
	public static <T> T getBeanByFullClassName(String classFullName) {
		try {
			@SuppressWarnings("unchecked")
			Class<T> requiredType = (Class<T>) Class.forName(classFullName);
			if (applicationContext != null)
				return applicationContext.getBean(requiredType);
		} catch (ClassNotFoundException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/**
	 * applicationContext是否含有该类
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:36:25
	 * @param name bean名称
	 * @return 是否含有
	 *
	 */
	public static boolean containsBean(String name) {
		try {
			if (applicationContext != null)
				return applicationContext.containsBean(name);
		} catch (BeansException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return false;
	}

	/**
	 * 判断以给定名字注册的bean定义是一个singleton还是一个prototype，
	 * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:38:22
	 * @param name bean名称
	 * @return
	 *
	 */
	public static boolean isSingleton(String name) {
		try {
			if (applicationContext != null)
				return applicationContext.isSingleton(name);
		} catch (BeansException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return false;
	}

	/**
	 * Class 注册对象的类型
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:39:53
	 * @param name bean名称
	 * @return
	 *
	 */
	public static Class<?> getType(String name) {
		try {
			if (applicationContext != null)
				return applicationContext.getType(name);
		} catch (BeansException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/**
	 * 如果给定的bean名字在bean定义中有别名，则返回这些别名
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 09:40:27
	 * @param name bean名称
	 * @return
	 *
	 */
	public static String[] getAliases(String name) {
		try {
			if (applicationContext != null)
				return applicationContext.getAliases(name);
		} catch (BeansException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}
}