package com.sunrise.core.daos.sysm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.TypedQuery;
import org.quartz.JobKey;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.controllers.sysm.dto.QuartzJobInfo;
import com.sunrise.core.entitys.SysQuartz;
import com.sunrise.core.utils.page.entitys.PageInfo;

/***
 * Quartz定时任务管理
 * 
 * @author Sun Rising
 * @date 2019.07.01 09:59:31
 *
 */
@Repository
public class QuartzDao extends BaseDao {

	/**
	 * 查询quartz
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 09:14:39
	 * @return
	 *
	 */
	public PageInfo querySysQuartz() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("SysQuartzQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<SysQuartz>(SysQuartz.class));
	}

	/**
	 * 获取job信息
	 * 
	 * @author Sun_Rising
	 * @date 2019.01.09 10:35:55
	 * @param jobKey
	 * @return
	 *
	 */
	public QuartzJobInfo getSysQuartzJobInfo(JobKey jobKey) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobName", jobKey.getName());
		map.put("jobGroup", jobKey.getGroup());
		final String sql = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("SysQuartzJobInfo.sql"), map);
		List<QuartzJobInfo> quartzJobInfos = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<QuartzJobInfo>(QuartzJobInfo.class));
		return quartzJobInfos.size() > 0 ? quartzJobInfos.get(0) : new QuartzJobInfo();
	}

	/**
	 * 获取SysQuartz对象
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 10:38:30
	 * @param quartzName
	 * @param quartzGroup
	 * @return
	 *
	 */
	public SysQuartz getSysQuartz(String quartzName, String quartzGroup) {
		final String jpql = "from SysQuartz where quartzName=:quartzName and quartzGroup=:quartzGroup";
		TypedQuery<SysQuartz> query = super.getEntityManager().createQuery(jpql, SysQuartz.class);
		query.setParameter("quartzName", quartzName);
		query.setParameter("quartzGroup", quartzGroup);
		List<SysQuartz> sysQuartzs = query.getResultList();
		return sysQuartzs.size() > 0 ? sysQuartzs.get(0) : null;
	}
}
