package com.sunrise.core.services.usrm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.config.exception.CustomRuntimeException;
import com.sunrise.core.controllers.usrm.form.RoleFormBean;
import com.sunrise.core.daos.usrm.PermDao;
import com.sunrise.core.daos.usrm.RoleDao;
import com.sunrise.core.entitys.SysPerm;
import com.sunrise.core.entitys.SysRole;
import com.sunrise.core.entitys.SysRolePerm;
import com.sunrise.core.utils.page.entitys.PageInfo;

/***
 * 角色管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 11:43:59
 *
 */
@Service
public class RoleService extends BaseService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PermDao permDao;

	/**
	 * 保存或更新角色
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:30:07
	 * @param list
	 * @throws Exception
	 *
	 */
	@Transactional
	public void saveSysRole(RoleFormBean roleFormBean) throws Exception {
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(sysRole, roleFormBean);
		// 判重
		if (StringUtils.isNotBlank(sysRole.getRoleCode())) {
			if (!roleDao.checkUnique(sysRole, "roleCode")) {
				throw new CustomRuntimeException("角色编码重复");
			}
		}
		// 保存sysRole
		if (StringUtils.isNotBlank(sysRole.getUuid())) {
			roleDao.mergeAutoWriteMsg(sysRole);
		} else {
			roleDao.persistAutoWriteMsg(sysRole);
		}
		// 保存关联信息
		Map<String, List<String>> map = roleFormBean.getPermUuids();
		for (String permType : map.keySet()) {
			SysPerm sysPerm = permDao.getSysPermByPermType(permType);
			if (sysPerm == null) {
				return;
			}
			roleDao.cleanRolePerm(sysRole.getUuid(), sysPerm.getUuid());
			List<String> list = map.get(permType);
			for (String uuid : list) {
				SysRolePerm sysRolePerm = new SysRolePerm();
				sysRolePerm.setRoleUuid(sysRole.getUuid());
				sysRolePerm.setPermUuid(sysPerm.getUuid());
				sysRolePerm.setResoUuid(uuid);
				roleDao.persistAutoWriteMsg(sysRolePerm);
			}
		}
	}

	/**
	 * 获取角色列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:30:36
	 * @return
	 *
	 */
	@Transactional
	public PageInfo querySysRole() {
		return roleDao.querySysRole();
	}

	/**
	 * 删除角色
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:24
	 * @param uuids uuid数组
	 *
	 */
	@Transactional
	public void delSysRole(String[] uuids) {
		for (String uuid : uuids) {
			SysRole sysRole = roleDao.getEntityManager().find(SysRole.class, uuid);
			if (sysRole != null) {
				roleDao.getEntityManager().remove(sysRole);
			}
		}
	}

	/**
	 * 获取已选择的资源信息
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 10:23:48
	 * @param roleUuid
	 * @return
	 *
	 */
	@Transactional
	public Map<String, List<String>> getSelectPerm(String roleUuid) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<SysPerm> sysPerms = permDao.getAvailSysPerm();
		for (SysPerm sysPerm : sysPerms) {
			map.put(sysPerm.getPermType(), roleDao.getRolePermRoseUuidsByRoleUuidAndPermUuid(roleUuid, sysPerm.getUuid()));
		}
		return map;
	}

	/**
	 * 通过组织机构UUID获取角色
	 * 
	 * @author Sun Rising
	 * @date 2019.06.29 07:25:29
	 * @param orgUuid
	 * @return
	 *
	 */
	public List<SysRole> getRoleByOrgUuid(String orgUuid) {
		return roleDao.getRoleByOrgUuid(orgUuid);
	}
}
