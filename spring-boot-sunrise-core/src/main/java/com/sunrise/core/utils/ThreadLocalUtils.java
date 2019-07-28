package com.sunrise.core.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程本地变量处理工具类,ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量.
 * 
 * @author Sun_Rising
 * @date 2018.12.27 01:22:48
 *
 */
public class ThreadLocalUtils {

	private final static ThreadLocal<Map<String, Object>> threadContext = new ThreadLocal<Map<String, Object>>();

	/**
	 * 存入变量
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:23:18
	 * @param key
	 * @param value
	 *
	 */
	public static void put(String key, Object value) {
		getContextMap().put(key, value);
	}

	/**
	 * 移除变量
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:23:30
	 * @param key
	 * @return
	 *
	 */
	public static Object remove(String key) {
		return getContextMap().remove(key);
	}

	/**
	 * 获取变量
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:23:39
	 * @param key
	 * @return
	 *
	 */
	public static Object get(String key) {
		return getContextMap().get(key);
	}

	/**
	 * 获取变量容器map
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:23:50
	 * @return
	 *
	 */
	public static Map<String, Object> getContextMap() {
		Map<String, Object> threadContextMap = threadContext.get();
		if (threadContextMap == null) {
			threadContextMap = new ConcurrentHashMap<String, Object>();
			threadContext.set(threadContextMap);
		}
		return threadContextMap;
	}

	/**
	 * 清空变量容器map
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:24:01
	 *
	 */
	public static void clearContext() {
		getContextMap().clear();
	}

	/**
	 * 使用规定好的key,用于Session
	 * 
	 * @author Sun Rising
	 * @date 2019.05.30 11:36:08
	 * @param sessionId
	 * @param key
	 * @return
	 *
	 */
	public static String getKey(String sessionId, String key) {
		return sessionId + key;
	}
}