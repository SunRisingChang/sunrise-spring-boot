package com.sunrise.core.utils.page.factory.handle;

/**
 * 数据库类型枚举
 * 
 * @author Sun Rising
 * @date 2019.05.29 09:28:47
 *
 */
public enum DataBaseType {
	MYSQL("MySQL", "com.sunrise.core.utils.page.factory.handle.imp.MySqlHandle"),
	ORACLE("Oracle", "com.sunrise.core.utils.page.factory.handle.imp.OracleHandle"),
	DB2("Db2", "com.sunrise.core.utils.page.factory.handle.imp.Db2Handle"),
	HSQLDB("Hsqldb", "com.sunrise.core.utils.page.factory.handle.imp.HsqldbHandle"),
	INFORMIX("Informix", "com.sunrise.core.utils.page.factory.handle.imp.InformixHandle"),
	SQLSERVER("microsoft SQL Server", "com.sunrise.core.utils.page.factory.handle.imp.SqlServerHandle");

	// key
	private String key;

	// classPath
	private String classPath;

	private DataBaseType(String key, String classPath) {
		this.key = key;
		this.classPath = classPath;
	}

	public String getKey() {
		return key;
	}

	public String getClassPath() {
		return classPath;
	}

	/**
	 * 通过数据类型获取数据类型枚举
	 * 
	 * @author Sun Rising
	 * @date 2019.05.29 10:08:44
	 * @param key 数据库类型
	 * @return
	 * @throws Exception
	 *
	 */
	public static DataBaseType findTypeEnumByKey(String key) throws Exception {
		DataBaseType tepBaseType = null;
		for (DataBaseType dataBaseTypeEnum : DataBaseType.values()) {
			if (dataBaseTypeEnum.getKey().equals(key)) {
				tepBaseType = dataBaseTypeEnum;
			}
		}
		if (tepBaseType == null) {
			throw new Exception("未找到支持的数据库分页处理器.");
		}
		return tepBaseType;
	}
}
