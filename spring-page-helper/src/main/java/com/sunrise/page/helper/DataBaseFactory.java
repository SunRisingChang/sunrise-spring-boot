package com.sunrise.page.helper;

import com.sunrise.page.helper.handle.DataBaseHandle;

/**
 * 数据库类型工厂
 * 
 * @author Sun Rising
 * @date 2019.05.27 08:39:56
 *
 */
public abstract class DataBaseFactory {

	/**
	 * 获取数据库分页处理器
	 * 
	 * @author Sun Rising
	 * @date 2019.05.29 10:22:32
	 * @param dbType 数据库枚举
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 *
	 */
	public static DataBaseHandle getDataBaseHandle(DataBaseType dbType)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> classObj = Class.forName(dbType.getClassPath());
		return (DataBaseHandle) classObj.newInstance();
	}
}
