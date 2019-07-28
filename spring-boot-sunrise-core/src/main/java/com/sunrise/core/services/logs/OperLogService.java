package com.sunrise.core.services.logs;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.daos.logs.OperLogDao;
import com.sunrise.core.entitys.LogOper;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 交互日志管理
 * 
 * @author Sun Rising
 * @date 2019.07.03 09:24:29
 *
 */
@Service
public class OperLogService extends BaseService {

	@Autowired
	private OperLogDao operLogDao;

	/**
	 * 查询交互日志
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 10:05:52
	 * @return
	 *
	 */
	@Transactional
	public PageInfo queryLogOper() {
		return operLogDao.queryLogOper();
	}

	/**
	 * 保存交互日志
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 10:09:19
	 *
	 */
	@Transactional
	public void saveLogOper(LogOper logOper) {
		if (StringUtils.isNotBlank(logOper.getUuid())) {
			operLogDao.getEntityManager().merge(logOper);
		} else {
			operLogDao.getEntityManager().persist(logOper);
		}
	}
}
