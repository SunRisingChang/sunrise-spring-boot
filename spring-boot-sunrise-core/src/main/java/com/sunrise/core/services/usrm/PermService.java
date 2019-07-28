package com.sunrise.core.services.usrm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.config.exception.CustomRuntimeException;
import com.sunrise.core.daos.usrm.PermDao;
import com.sunrise.core.entitys.SysPerm;
import com.sunrise.core.utils.UnderlineToCamelUtils;
import com.sunrise.core.utils.page.entitys.PageInfo;

/***
 * 权限管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 11:43:59
 *
 */
@Service
public class PermService extends BaseService {

	@Autowired
	private PermDao permDao;

	/**
	 * 保存或更新权限
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:30:07
	 * @param list
	 * @throws Exception
	 *
	 */
	@Transactional
	public void saveSysPerm(SysPerm sysPerm) throws Exception {
		if (StringUtils.isNotBlank(sysPerm.getPermTable())) {
			// 判重
			if (!permDao.checkUnique(sysPerm, "permTable")) {
				throw new CustomRuntimeException("资源权限重复");
			}
			if (!permDao.checkTableExist(sysPerm.getPermTable())) {
				throw new CustomRuntimeException("不存在的资源表");
			}
		}
		if (StringUtils.isNotBlank(sysPerm.getUuid())) {
			permDao.mergeAutoWriteMsg(sysPerm);
		} else {
			permDao.persistAutoWriteMsg(sysPerm);
		}
	}

	/**
	 * 获取权限列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:30:36
	 * @return
	 *
	 */
	@Transactional
	public PageInfo querySysPerm() {
		return permDao.querySysPerm();
	}

	/**
	 * 删除权限
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:24
	 * @param uuids uuid数组
	 *
	 */
	@Transactional
	public void delSysPerm(String[] uuids) {
		for (String uuid : uuids) {
			SysPerm sysPerm = permDao.getEntityManager().find(SysPerm.class, uuid);
			if (sysPerm != null) {
				permDao.getEntityManager().remove(sysPerm);
			}
		}
	}

	/**
	 * 获取所有的权限资源
	 * 
	 * @author Sun Rising
	 * @date 2019.06.27 09:48:16
	 * @return
	 *
	 */
	@Transactional
	public Map<String, Object> getPermMap() {
		Map<String, Object> permMap = new HashMap<String, Object>();
		List<SysPerm> sysPerms = permDao.getAvailSysPerm();
		for (SysPerm sysPerm : sysPerms) {
			String entityClassName = UnderlineToCamelUtils.underlineToCamel(sysPerm.getPermTable(), false);
			permMap.put(sysPerm.getPermType(), permDao.getPermInfo(entityClassName));
		}
		return permMap;
	}
}
