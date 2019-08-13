package com.sunrise.page.helper.handle.imp;

import com.sunrise.page.helper.entitys.PageInfo;
import com.sunrise.page.helper.handle.DataBaseHandle;

/**
 * MysqlSQL语句处理器
 * 
 * @author Sun Rising
 * @date 2019.05.27 08:42:38
 *
 */
public class MySqlHandle implements DataBaseHandle {

	@Override
	public String getPageSql(String sql, PageInfo page) {
		// 获取当前页码
		int currPageNum = page.getCurrentPageNum();
		// 获取每页数据数
		int pageSize = page.getPageSize();
		// 拼接语句
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 14);
		sqlBuilder.append(sql);
		sqlBuilder.append(" LIMIT ");
		sqlBuilder.append((currPageNum - 1) * pageSize);
		sqlBuilder.append(",");
		sqlBuilder.append(pageSize);
		return sqlBuilder.toString();
	}

	@Override
	public String getTotalRecords(String sql) {
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 14);
		sqlBuilder.append("SELECT COUNT(*) FROM (");
		sqlBuilder.append(sql);
		sqlBuilder.append(") t");
		return sqlBuilder.toString();
	}
}
