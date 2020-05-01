package com.sunrise.core.digcer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * KeyStore管理工具
 * 
 * @author Sun_Rising
 * @date 2019.01.04 09:35:13
 *
 */
public class KeyStoreUtility {

	private static final Logger logger = LoggerFactory.getLogger(KeyStoreUtility.class);

	private static String KEY_STRORE_PATH = "KEYSTORE.KeyStore";

	private static String KEY_STRORE_PASSWORD = "11111111";
	static {
		// 添加BC支持
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * 读取文件中的KeyStore
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.04 09:35:28
	 * @param stream
	 * @param password
	 * @return
	 * @throws Exception
	 *
	 */
	public static KeyStore getKeyStore(InputStream stream, char[] password) throws Exception {
		KeyStore store = KeyStore.getInstance("PKCS12", "BC");
		store.load(stream, password);
		return store;
	}

	/**
	 * 获取新的KeyStore
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.04 09:36:40
	 * @return
	 * @throws Exception
	 *
	 */
	public static KeyStore getKeyStore() throws Exception {
		KeyStore store = KeyStore.getInstance("PKCS12", "BC");
		File file = new File(KEY_STRORE_PATH);
		if (file.exists()) {
			store.load(new FileInputStream(KEY_STRORE_PATH), KEY_STRORE_PASSWORD.toCharArray());
		} else {
			store.load(null, null);
		}
		return store;
	}

	/**
	 * 存放私钥
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.04 05:53:00
	 * @param alias
	 * @param privateKey
	 *
	 */
	public static void putKey(String alias, PrivateKey privateKey) {
		try {
			KeyStore keyStore = KeyStoreUtility.getKeyStore();
			keyStore.setKeyEntry(alias, privateKey.getEncoded(), new Certificate[0]);
//			keyStore.store(new FileOutputStream(new File(KEY_STRORE_PATH)), KEY_STRORE_PASSWORD.toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("密钥[" + alias + "]存放失败." + e.getMessage());
		}
	}
}
