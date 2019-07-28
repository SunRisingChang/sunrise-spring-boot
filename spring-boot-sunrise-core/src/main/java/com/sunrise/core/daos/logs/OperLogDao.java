package com.sunrise.core.daos.logs;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.LogOper;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 交互日志管理
 * 
 * @author Sun Rising
 * @date 2019.07.03 09:25:06
 *
 */
@Repository
public class OperLogDao extends BaseDao {

	/**
	 * 查询交互日志
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 10:05:58
	 * @return
	 *
	 */
	public PageInfo queryLogOper() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("LogOperQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<LogOper>(LogOper.class));
	}
}
