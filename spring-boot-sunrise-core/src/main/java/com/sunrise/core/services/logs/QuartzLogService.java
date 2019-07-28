package com.sunrise.core.services.logs;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.daos.logs.QuartzLogDao;
import com.sunrise.core.entitys.LogQuartz;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * Quartz日志管理
 * 
 * @author Sun Rising
 * @date 2019.07.03 09:24:29
 *
 */
@Service
public class QuartzLogService extends BaseService {

	@Autowired
	private QuartzLogDao quartzLogDao;

	/**
	 * 查询Quartz日志
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 10:05:52
	 * @return
	 *
	 */
	@Transactional
	public PageInfo queryLogQuartz() {
		return quartzLogDao.queryLogQuartz();
	}

	/**
	 * 保存Quartz日志
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 10:09:19
	 *
	 */
	@Transactional
	public void saveLogQuartz(LogQuartz logQuartz) {
		if (StringUtils.isNotBlank(logQuartz.getUuid())) {
			quartzLogDao.getEntityManager().merge(logQuartz);
		} else {
			quartzLogDao.getEntityManager().persist(logQuartz);
		}
	}
}
