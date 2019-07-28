package com.sunrise.config.digcer;

import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * cer格式数字证书读取工具
 * 
 * @author Sun_Rising
 * @date 2019.01.08 09:17:54
 *
 */
public class CERFileUtility {

	private static final Logger logger = LoggerFactory.getLogger(CERFileUtility.class);

	public static void main(String[] args) {
		new CERFileUtility().getCerInfo("sign.cer");
	}

	/**
	 * 获取cer文件信息
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.08 09:29:16
	 * @param path
	 *
	 */
	public void getCerInfo(String path) {
		try (FileInputStream fileInputStream = new FileInputStream(path)) {
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			System.out.println("读取Cer证书信息...");
			System.out.println("证书版本: V" + x509Certificate.getVersion());
			System.out.println("序列号:" + x509Certificate.getSerialNumber().toString(16));
			System.out.println("证书生效日期:" + dateformat.format(x509Certificate.getNotBefore()));
			System.out.println("证书失效日期:" + dateformat.format(x509Certificate.getNotAfter()));
			System.out.println("证书拥有者:" + getDNinfo(x509Certificate.getSubjectDN().toString()).get("CN"));
			System.out.println("证书颁发者:" + getDNinfo(x509Certificate.getIssuerDN().toString()).get("CN"));
			System.out.println("证书签名算法:" + x509Certificate.getSigAlgName());
			System.out.println("发布方标识:" + x509Certificate.getIssuerDN());
			System.out.println("主体方标识:" + x509Certificate.getSubjectDN());
			System.out.println("公钥BASE64:" + Base64.getEncoder().encodeToString(x509Certificate.getPublicKey().getEncoded()));
			System.out.println("公钥信息:" + x509Certificate.getPublicKey());
		} catch (Exception e) {
			logger.error("获取cer文件[" + path + "]信息失败!" + e.getMessage());
		}
	}

	/**
	 * 解析DN字符串
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.08 09:57:09
	 * @param dn
	 * @return
	 *
	 */
	public Map<String, String> getDNinfo(String dn) {
		Map<String, String> map = new HashMap<>();
		String[] dns = dn.split(",");
		for (String s : dns) {
			int currindex = s.indexOf("=");
			if (currindex > 0) {
				String key = s.substring(0, currindex).trim();
				String value = s.substring(currindex + 1).trim();
				map.put(key, value);
			}
		}
		return map;
	}

	/**
	 * 创建cer证书
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.10 02:55:34
	 * @param path
	 *
	 */
	public void createCerFile(String path) {
	}
}
