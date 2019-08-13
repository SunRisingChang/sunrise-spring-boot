package com.sunrise.page.helper;

import com.sunrise.page.helper.handle.DataBaseHandle;

/**
 * 数据库分页SQL处理工具类
 * 
 * @author Sun Rising
 * @date 2019.05.27 08:43:41
 *
 */
public class DataPageUtils {

	/**
	 * 获取数据库处理器
	 * 
	 * @author Sun Rising
	 * @date 2019.05.29 09:25:14
	 * @param dbType 数据库类型
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 *
	 */
	public static DataBaseHandle getDataPageUtils(DataBaseType dbType)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		return DataBaseFactory.getDataBaseHandle(dbType);
	}
}
