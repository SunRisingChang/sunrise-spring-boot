package com.sunrise.core.daos.logs;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.LogQuartz;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * Quartz日志管理
 * 
 * @author Sun Rising
 * @date 2019.07.03 09:25:06
 *
 */
@Repository
public class QuartzLogDao extends BaseDao {

	/**
	 * 查询Quartz日志
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 10:05:58
	 * @return
	 *
	 */
	public PageInfo queryLogQuartz() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("LogQuartzQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<LogQuartz>(LogQuartz.class));
	}
}
