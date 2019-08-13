package com.sunrise.page.helper.handle.imp;

import com.sunrise.page.helper.entitys.PageInfo;
import com.sunrise.page.helper.handle.DataBaseHandle;

/**
 * Oracle分页处理
 * 
 * @author Sun Rising
 * @date 2019.05.29 12:50:24
 *
 */
public class OracleHandle implements DataBaseHandle {

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
		if (startRow > 0) {
			sqlBuilder.append("SELECT * FROM ( ");
		}
		if (endRow > 0) {
			sqlBuilder.append(" SELECT TMP_PAGE.*, ROWNUM ROW_ID FROM ( ");
		}
		sqlBuilder.append(sql);
		if (endRow > 0) {
			sqlBuilder.append(" ) TMP_PAGE WHERE ROWNUM <= ");
			sqlBuilder.append(endRow);
		}
		if (startRow > 0) {
			sqlBuilder.append(" ) WHERE ROW_ID > ");
			sqlBuilder.append(startRow);
		}
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
