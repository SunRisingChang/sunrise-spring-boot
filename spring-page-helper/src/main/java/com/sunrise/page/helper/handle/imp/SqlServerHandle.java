package com.sunrise.page.helper.handle.imp;

import com.sunrise.page.helper.entitys.PageInfo;
import com.sunrise.page.helper.handle.DataBaseHandle;

/**
 * SqlServerSql处理器
 * 
 * @author Sun Rising
 * @date 2019.05.29 12:55:59
 *
 */
public class SqlServerHandle implements DataBaseHandle {

	@Override
	public String getPageSql(String sql, PageInfo page) {
		// 获取当前页码
		int currPageNum = page.getCurrentPageNum();
		// 获取每页数据数
		int pageSize = page.getPageSize();
		// 起始行
		int startRow = currPageNum * pageSize;
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 14);
		sqlBuilder.append(sql);
		sqlBuilder.append(" OFFSET ");
		sqlBuilder.append(startRow);
		sqlBuilder.append(" ROWS ");
		sqlBuilder.append(" FETCH NEXT ");
		sqlBuilder.append(pageSize);
		sqlBuilder.append(" ROWS ONLY");
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
