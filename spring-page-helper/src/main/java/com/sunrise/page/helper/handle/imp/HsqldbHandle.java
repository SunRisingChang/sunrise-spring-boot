package com.sunrise.page.helper.handle.imp;

import com.sunrise.page.helper.entitys.PageInfo;
import com.sunrise.page.helper.handle.DataBaseHandle;

/**
 * hsqldb SQL分页处理器
 * 
 * @author Sun Rising
 * @date 2019.05.29 01:01:58
 *
 */
public class HsqldbHandle implements DataBaseHandle {

	@Override
	public String getPageSql(String sql, PageInfo page) {
		// 获取当前页码
		int currPageNum = page.getCurrentPageNum();
		// 获取每页数据数
		int pageSize = page.getPageSize();
		// 起始行
		int startRow = currPageNum * pageSize;
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 20);
		sqlBuilder.append(sql);
		if (pageSize > 0) {
			sqlBuilder.append(" LIMIT ");
			sqlBuilder.append(pageSize);
		}
		if (startRow > 0) {
			sqlBuilder.append(" OFFSET ");
			sqlBuilder.append(startRow);
		}
		return sqlBuilder.toString();
	}

	@Override
	public String getTotalRecords(String sql) {
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 20);
		sqlBuilder.append("SELECT COUNT(*) FROM (");
		sqlBuilder.append(sql);
		sqlBuilder.append(") t");
		return sqlBuilder.toString();
	}
}
