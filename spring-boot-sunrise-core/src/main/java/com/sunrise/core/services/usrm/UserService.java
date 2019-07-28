package com.sunrise.core.services.usrm;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.config.exception.CustomRuntimeException;
import com.sunrise.core.constant.ExceptionConst;
import com.sunrise.core.constant.SystemConst;
import com.sunrise.core.controllers.usrm.form.UserFormBean;
import com.sunrise.core.daos.usrm.UserDao;
import com.sunrise.core.entitys.SysUser;
import com.sunrise.core.entitys.SysUserInfo;
import com.sunrise.core.entitys.SysUserRole;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 用户管理
 * 
 * @author Sun Rising
 * @date 2019.06.19 08:34:56
 *
 */
@Service
public class UserService extends BaseService {

	@Autowired
	private UserDao userDao;

	/**
	 * 查询用户
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 09:56:15
	 * @return
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public PageInfo querySysUser() {
		PageInfo pageInfo = userDao.querySysUser();
		for (UserFormBean userFormBean : (List<UserFormBean>) pageInfo.getDataBody()) {
			List<SysUserRole> sysUserRoles = userDao.getUserRoleByUserUuid(userFormBean.getUuid());
			for (SysUserRole sysUserRole : sysUserRoles)
				userFormBean.getRoleUuids().add(sysUserRole.getRoleUuid());
		}
		return pageInfo;
	}

	/**
	 * 保存用户
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 10:00:53
	 * @param userFormBean
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 *
	 */
	@Transactional
	public void saveSysUser(UserFormBean userFormBean) throws Exception {
		SysUser sysUser = new SysUser();
		SysUserInfo sysUserInfo = new SysUserInfo();
		BeanUtils.copyProperties(sysUser, userFormBean);
		BeanUtils.copyProperties(sysUserInfo, userFormBean);
		if (StringUtils.isNotBlank(userFormBean.getUuid())) {
			userDao.mergeAutoWriteMsg(sysUser);
			SysUserInfo _sysUserInfo = userDao.getSysUserInfoByUserUuid(sysUser.getUuid());
			sysUserInfo.setUserUuid(sysUser.getUuid());
			sysUserInfo.setUuid(_sysUserInfo.getUuid());
			userDao.mergeAutoWriteMsg(sysUserInfo);
		} else {
			userDao.persistAutoWriteMsg(sysUser);
			sysUserInfo.setUserUuid(sysUser.getUuid());
			sysUserInfo.setUuid(null);
			userDao.persistAutoWriteMsg(sysUserInfo);
		}
		// 处理用户-角色关联
		userDao.cleanUserRoleByUserUuid(sysUser.getUuid());
		for (String roleUuid : userFormBean.getRoleUuids()) {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUserUuid(sysUser.getUuid());
			sysUserRole.setRoleUuid(roleUuid);
			userDao.persistAutoWriteMsg(sysUserRole);
		}
	}

	/**
	 * 删除用户
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 09:55:59
	 * @param uuids
	 *
	 */
	@Transactional
	public void delSysUser(String[] uuids) {
		for (String uuid : uuids) {
			if (StringUtils.isNotBlank(uuid)) {
				SysUser sysUser = userDao.getEntityManager().find(SysUser.class, uuid);
				if (sysUser != null)
					userDao.getEntityManager().remove(sysUser);
				SysUserInfo sysUserInfo = userDao.getSysUserInfoByUserUuid(uuid);
				if (sysUserInfo != null)
					userDao.getEntityManager().remove(sysUserInfo);
				// 处理用户-角色关联
				userDao.cleanUserRoleByUserUuid(uuid);
			} else {
				throw new CustomRuntimeException(ExceptionConst.HTTP_NO_FOUND_PARAMS.getCode(), ExceptionConst.HTTP_NO_FOUND_PARAMS.getMessage());
			}
		}
	}

	/**
	 * 用户锁定
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:25:57
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@Transactional
	public void userLock(String[] uuids) throws Exception {
		for (String uuid : uuids) {
			SysUser sysUser = userDao.getEntityManager().find(SysUser.class, uuid);
			if (sysUser != null && SystemConst.ACCOUNT_NORMAL.equals(sysUser.getAcStat())) {
				sysUser.setAcStat(SystemConst.ACCOUNT_LOCK);
				userDao.mergeAutoWriteMsg(sysUser);
			}
		}
	}

	/**
	 * 用户解锁
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:26:11
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@Transactional
	public void userUnlock(String[] uuids) throws Exception {
		for (String uuid : uuids) {
			SysUser sysUser = userDao.getEntityManager().find(SysUser.class, uuid);
			if (sysUser != null && SystemConst.ACCOUNT_LOCK.equals(sysUser.getAcStat())) {
				sysUser.setAcStat(SystemConst.ACCOUNT_NORMAL);
				userDao.mergeAutoWriteMsg(sysUser);
			}
		}
	}

	/**
	 * 用户注销
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:26:26
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@Transactional
	public void userDest(String[] uuids) throws Exception {
		for (String uuid : uuids) {
			SysUser sysUser = userDao.getEntityManager().find(SysUser.class, uuid);
			if (sysUser != null && !SystemConst.ACCOUNT_DEST.equals(sysUser.getAcStat())) {
				sysUser.setAcStat(SystemConst.ACCOUNT_DEST);
				userDao.mergeAutoWriteMsg(sysUser);
			}
		}
	}
}
