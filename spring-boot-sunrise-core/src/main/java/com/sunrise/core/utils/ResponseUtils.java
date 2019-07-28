package com.sunrise.core.utils;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.apache.commons.lang3.StringUtils;

/**
 * HttpServletResponse 处理类
 * 
 * @author Sun Rising
 * @date 2019.07.03 05:22:40
 *
 */
public class ResponseUtils {

	private static String SERVER_IP = null;

	private static String SERVER_NAME = null;

	/**
	 * 获取服务器IP
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 05:24:11
	 * @return
	 *
	 */
	public static String getServerIP() {
		try {
			if (StringUtils.isBlank(SERVER_IP)) {
				final Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
				while (enumeration.hasMoreElements()) {
					final NetworkInterface networkInterface = enumeration.nextElement();
					if (networkInterface.isUp() && !networkInterface.isLoopback() && !networkInterface.isPointToPoint() && !networkInterface.isVirtual() && networkInterface.getDisplayName().toLowerCase().indexOf("virtual") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("vmnetadapter") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("ppoe") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("bthpan") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("tapvpn") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("ndisip") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("sinforvnic") == -1) {
						final Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
						while (addressEnumeration.hasMoreElements()) {
							final InetAddress inetAddress = addressEnumeration.nextElement();
							if (inetAddress instanceof Inet4Address) {
								final Inet4Address inet4Address = (Inet4Address) inetAddress;
								SERVER_IP = inet4Address.getHostAddress();
								return SERVER_IP;
							} else if (inetAddress instanceof Inet6Address) {
								final Inet6Address inet6Address = (Inet6Address) inetAddress;
								SERVER_IP = inet6Address.getHostAddress();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			SERVER_IP = "Unknown Host";
		}
		return SERVER_IP;
	}

	/**
	 * 获取服务器名称
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 05:25:07
	 * @return
	 *
	 */
	public static String getServerName() {
		try {
			if (StringUtils.isBlank(SERVER_NAME)) {
				if (System.getenv().get("COMPUTERNAME") != null) {
					SERVER_NAME = System.getenv().get("COMPUTERNAME").toString();
				} else {
					final Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
					while (enumeration.hasMoreElements()) {
						final NetworkInterface networkInterface = enumeration.nextElement();
						if (networkInterface.isUp() && !networkInterface.isLoopback() && !networkInterface.isPointToPoint() && !networkInterface.isVirtual() && networkInterface.getDisplayName().toLowerCase().indexOf("virtual") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("vmnetadapter") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("ppoe") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("bthpan") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("tapvpn") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("ndisip") == -1 && networkInterface.getDisplayName().toLowerCase().indexOf("sinforvnic") == -1) {
							final Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
							while (addressEnumeration.hasMoreElements()) {
								final InetAddress inetAddress = addressEnumeration.nextElement();
								if (inetAddress instanceof Inet4Address) {
									final Inet4Address inet4Address = (Inet4Address) inetAddress;
									SERVER_NAME = inet4Address.getHostName();
									return SERVER_NAME;
								} else if (inetAddress instanceof Inet6Address) {
									final Inet6Address inet6Address = (Inet6Address) inetAddress;
									SERVER_NAME = inet6Address.getHostName();
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			SERVER_NAME = "Unknown Host";
		}
		return SERVER_NAME;
	}
}
