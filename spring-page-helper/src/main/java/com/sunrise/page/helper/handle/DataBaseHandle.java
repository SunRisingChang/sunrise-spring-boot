package com.sunrise.page.helper.handle;

import com.sunrise.page.helper.entitys.PageInfo;

/**
 * 数据库操作接口
 * 
 * @author Sun Rising
 * @date 2019.05.29 09:15:45
 *
 */
public interface DataBaseHandle {

	/**
	 * 获取分页sql语句
	 * 
	 * @author Sun Rising
	 * @date 2019.05.27 09:03:28
	 * @param sql  需要处理的SQL
	 * @param page 分页信息
	 * @return
	 *
	 */
	public abstract String getPageSql(String sql, PageInfo page);

	/**
	 * 获取记录总数
	 * 
	 * @author Sun Rising
	 * @date 2019.05.29 01:16:54
	 * @param sql
	 * @return
	 *
	 */
	public abstract String getTotalRecords(String sql);
}
