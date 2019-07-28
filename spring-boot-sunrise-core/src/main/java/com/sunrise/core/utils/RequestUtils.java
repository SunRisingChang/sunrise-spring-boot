package com.sunrise.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * HttpServletRequest 工具类
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:47:02
 *
 */
public class RequestUtils {

	private final static Logger logger = LoggerFactory.getLogger(FreemarkerUtils.class);

	final private static String CHAR_ENCOD = "UTF-8";

	/**
	 * 获取请求头信息
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:47:37
	 * @param request
	 * @return
	 *
	 */
	public static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * 获取request中form体中包含的全部参数(非json流)
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:52:51
	 * @param request
	 * @return
	 *
	 */
	public static Map<String, Object> getFormParams(HttpServletRequest request) {
		Map<String, Object> bodyMap = new HashMap<String, Object>();
		if (request.getMethod().equalsIgnoreCase("POST")) {
			Enumeration<String> parameterNames = request.getParameterNames();
			while (parameterNames.hasMoreElements()) {
				String parameterName = (String) parameterNames.nextElement();
				bodyMap.put(parameterName, CommonUtils.cleanXSS(request.getParameter(parameterName)));
			}
		}
		return bodyMap;
	}

	/**
	 * 获取Url中携带的所有参数
	 * 
	 * @author Sun Rising
	 * @date 2018.12.30 07:57:33
	 * @param request
	 * @return
	 *
	 */
	public static Map<String, Object> getUrlParams(HttpServletRequest request) {
		Map<String, Object> urlMaps = new HashMap<String, Object>();
		if (request.getMethod().equalsIgnoreCase("GET")) {
			String urlParamStr = request.getQueryString();
			if (StringUtils.isNotBlank(urlParamStr)) {
				String[] params = urlParamStr.split("&");
				for (String p : params) {
					String[] kv = p.split("=");
					if (kv.length == 2) {
						urlMaps.put(kv[0], kv[1]);
					}
				}
			}
		}
		return urlMaps;
	}

	/**
	 * 获取json流中携带的全部参数
	 * 
	 * @author Sun Rising
	 * @date 2018.12.30 08:04:14
	 * @param request
	 * @return
	 *
	 */
	public static Map<String, Object> getJsonParams(HttpServletRequest request) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		final String contentType = request.getContentType();
		if (StringUtils.isNotBlank(contentType) && contentType.toLowerCase().indexOf("application/json") != -1) {
			try (InputStream is = request.getInputStream()) {
				final String jsonstr = IOUtils.toString(is, CHAR_ENCOD);
				final ObjectMapper mapper = CommonUtils.getJacksonMapper();
				final TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
				};
				jsonMap = mapper.readValue(jsonstr, typeRef);
			} catch (IOException e) {
				logger.error("获取json流中携带的全部参数失败!" + e.getLocalizedMessage());
				return jsonMap;
			}
		}
		return jsonMap;
	}

	/**
	 * 获取请求的真实ip
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:48:06
	 * @param request
	 * @return
	 *
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = null;
		// X-Forwarded-For：Squid 服务代理
		String ipAddresses = request.getHeader("X-Forwarded-For");
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			// Proxy-Client-IP：apache 服务代理
			ipAddresses = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			// WL-Proxy-Client-IP：weblogic 服务代理
			ipAddresses = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			// HTTP_CLIENT_IP：有些代理服务器
			ipAddresses = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			// X-Real-IP：nginx服务代理
			ipAddresses = request.getHeader("X-Real-IP");
		}
		// 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
		if (ipAddresses != null && ipAddresses.length() != 0) {
			ip = ipAddresses.split(",")[0];
		}
		// 还是不能获取到，最后再通过request.getRemoteAddr();获取
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取代理的IP地址
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:48:20
	 * @param request
	 * @return
	 *
	 */
	public static String getProxyIpAddr(HttpServletRequest request) {
		String ipAddress = getIpAddr(request);
		if (!request.getRemoteAddr().equals(ipAddress)) {
			return request.getRemoteAddr();
		}
		return ipAddress;
	}
}