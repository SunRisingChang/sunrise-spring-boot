package com.sunrise.page.helper.handle.imp;

import com.sunrise.page.helper.entitys.PageInfo;
import com.sunrise.page.helper.handle.DataBaseHandle;

/**
 * DB2 SQL分页处理器
 * 
 * @author Sun Rising
 * @date 2019.05.29 01:04:02
 *
 */
public class Db2Handle implements DataBaseHandle {

	@Override
	public String getPageSql(String sql, PageInfo page) {
		// 获取当前页码
		int currPageNum = page.getCurrentPageNum();
		// 获取每页数据数
		int pageSize = page.getPageSize();
		// 起始行
		int startRow = currPageNum * pageSize;
		// 结束行
		int endRow = startRow + pageSize;
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 120);
		sqlBuilder.append("SELECT * FROM (SELECT TMP_PAGE.*,ROWNUMBER() OVER() AS ROW_ID FROM ( ");
		sqlBuilder.append(sql);
		sqlBuilder.append(" ) AS TMP_PAGE) TMP_PAGE WHERE ROW_ID BETWEEN ");
		sqlBuilder.append(startRow);
		sqlBuilder.append(" AND ");
		sqlBuilder.append(endRow);
		return sqlBuilder.toString();
	}

	@Override
	public String getTotalRecords(String sql) {
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 120);
		sqlBuilder.append("SELECT COUNT(*) FROM (");
		sqlBuilder.append(sql);
		sqlBuilder.append(") t");
		return sqlBuilder.toString();
	}
}
