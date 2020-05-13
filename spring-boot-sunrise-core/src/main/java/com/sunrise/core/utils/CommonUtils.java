package com.sunrise.core.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 通用工具类
 * 
 * @author Sun Rising
 * @date 2018.12.30 09:16:26
 *
 */
public class CommonUtils {

	/**
	 * 获取FastJson转换对象
	 * 
	 * @author Sun Rising
	 * @date 2018.12.30 08:17:42
	 * @return
	 *
	 */
	public static ObjectMapper getJacksonMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		// 允许单引号
		objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		// 禁用遇到未知属性抛出异常
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		// 禁用遇到未知属性抛出异常
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 视空字符传为null
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		return objectMapper;
	}

	/**
	 * 获取真实的服务IP
	 * 
	 * @author Sun Rising
	 * @date 2018.12.30 08:57:25
	 * @return
	 *
	 */
	public static String getServerIP() {
		String serverIp = null;
		try {
			final Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
			while (enumeration.hasMoreElements()) {
				final NetworkInterface networkInterface = enumeration.nextElement();
				if (networkInterface.isUp() && !networkInterface.isLoopback() && !networkInterface.isPointToPoint() && !networkInterface.isVirtual() && networkInterface.getDisplayName().toLowerCase().indexOf("virtual") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("vmnetadapter") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("ppoe") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("bthpan") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("tapvpn") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("ndisip") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("sinforvnic") == -1) {
					final Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
					while (addressEnumeration.hasMoreElements()) {
						final InetAddress inetAddress = addressEnumeration.nextElement();
						if (inetAddress instanceof Inet4Address) {
							final Inet4Address inet4Address = (Inet4Address) inetAddress;
							serverIp = inet4Address.getHostAddress();
							return serverIp;
						} else if (inetAddress instanceof Inet6Address) {
							final Inet6Address inet6Address = (Inet6Address) inetAddress;
							serverIp = inet6Address.getHostAddress();
						}
					}
				}
			}
		} catch (Exception e) {
			serverIp = "Unknown Host";
		}
		return serverIp;
	}

	/**
	 * 获取主机名称
	 * 
	 * @author Sun Rising
	 * @date 2018.12.30 09:14:33
	 * @return
	 *
	 */
	public static String getServerName() {
		String serverName = null;
		try {
			final Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
			while (enumeration.hasMoreElements()) {
				final NetworkInterface networkInterface = enumeration.nextElement();
				if (networkInterface.isUp() && !networkInterface.isLoopback() && !networkInterface.isPointToPoint() && !networkInterface.isVirtual() && networkInterface.getDisplayName().toLowerCase().indexOf("virtual") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("vmnetadapter") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("ppoe") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("bthpan") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("tapvpn") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("ndisip") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("sinforvnic") == -1) {
					final Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
					while (addressEnumeration.hasMoreElements()) {
						final InetAddress inetAddress = addressEnumeration.nextElement();
						if (inetAddress instanceof Inet4Address) {
							final Inet4Address inet4Address = (Inet4Address) inetAddress;
							serverName = inet4Address.getHostName();
							return serverName;
						} else if (inetAddress instanceof Inet6Address) {
							final Inet6Address inet6Address = (Inet6Address) inetAddress;
							serverName = inet6Address.getHostName();
						}
					}
				}
			}
		} catch (Exception e) {
			serverName = "Unknown Host";
		}
		return serverName;
	}

	/**
	 * 获取被拦截方法唯一标识
	 * 
	 * @author Sun Rising
	 * @date 2018.12.30 09:02:21
	 * @param pjp AOP拦截对象
	 * @return
	 *
	 */
	public static String methodUniqueId(ProceedingJoinPoint pjp) {
		final Object objInstance = pjp.getTarget();
		final MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		final Method method = methodSignature.getMethod();
		final String serviceClass = objInstance.getClass().getName();
		final String serviceMethod = method.getName();
		final Class<?>[] types = methodSignature.getParameterTypes();
		final String signature = StringUtils.join(types);
		final String serviceId = serviceClass + "." + serviceMethod;
		return serviceId + signature;
	}

	/**
	 * 获取异常堆栈的全部信息
	 * 
	 * @author Sun Rising
	 * @date 2018.12.30 09:06:19
	 * @param e 异常
	 * @return
	 *
	 */
	public static String getFullMessage(Throwable e) {
		String msg = e.getMessage();
		if (e.getCause() != null)
			msg = msg + "\n" + getFullMessage(e.getCause());
		return msg;
	}

	/**
	 * 清除XSS攻击字符
	 * 
	 * @author Sun Rising
	 * @date 2018.12.30 07:50:50
	 * @param value
	 * @return
	 *
	 */
	public static String cleanXSS(String value) {
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("\"", "&quot;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
	}

	/**
	 * 文件排序
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:06:32
	 * @param files
	 * @param orderStr
	 * @return
	 *
	 */
	public static List<File> sortFileByName(List<File> files, final String orderStr) {
		if (!(orderStr.equalsIgnoreCase("asc") || orderStr.equalsIgnoreCase("desc"))) {
			return files;
		}
		File[] files1 = files.toArray(new File[0]);
		Arrays.sort(files1, new Comparator<File>() {

			public int compare(File o1, File o2) {
				int n1 = extractNumber(o1.getName());
				int n2 = extractNumber(o2.getName());
				if (orderStr == null || orderStr.length() < 1 || orderStr.equalsIgnoreCase("asc")) {
					return n1 - n2;
				} else {
					// 降序
					return n2 - n1;
				}
			}
		});
		return new ArrayList<File>(Arrays.asList(files1));
	}

	private static int extractNumber(String name) {
		int i;
		try {
			String number = name.replaceAll("[^\\d]", "");
			i = Integer.parseInt(number);
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	/**
	 * 获取微秒
	 * 
	 * @author Sun Rising
	 * @date 2020.04.26 09:08:10
	 * @return
	 *
	 */
	public static Long getmicTime() {
		Long cutime = System.currentTimeMillis() * 1000; // 微秒
		Long nanoTime = System.nanoTime(); // 纳秒
		return cutime + (nanoTime - nanoTime / 1000000 * 1000000) / 1000;
	}

	/**
	 * 字符串扁平化
	 * 
	 * @author Sun Rising
	 * @date 2020.05.03 10:22:48
	 *
	 */
	public static String stringFlat(String string) {
		string = string.replaceAll("\\r\\n", " ");
		string = string.replaceAll("\\s+", " ");
		return string;
	}
}
