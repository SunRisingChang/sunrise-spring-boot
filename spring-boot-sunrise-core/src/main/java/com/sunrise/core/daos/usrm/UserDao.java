package com.sunrise.core.daos.usrm;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.controllers.usrm.form.UserFormBean;
import com.sunrise.core.entitys.SysUser;
import com.sunrise.core.entitys.SysUserInfo;
import com.sunrise.core.entitys.SysUserRole;
import com.sunrise.core.utils.page.entitys.PageInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户管理
 * 
 * @author Sun Rising
 * @date 2019.06.19 08:33:44
 *
 */
@Slf4j
@Repository
public class UserDao extends BaseDao {

	/**
	 * 通过用户名获取用户
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:16:53
	 * @param userName
	 * @return 如果没有匹配到返回null,匹配到多个返回第一个并打印日志
	 *
	 */
	public SysUser getSysUserByName(String acName) {
		String jpql = "FROM SysUser WHERE acName=:acName";
		TypedQuery<SysUser> query = getEntityManager().createQuery(jpql, SysUser.class);
		query.setParameter("acName", acName);
		List<SysUser> sysUsers = query.getResultList();
		if (sysUsers.size() == 0)
			return null;
		if (sysUsers.size() > 1)
			log.error("[Security]SysUser用户名重复，请DBA及时处理. -[" + this.getClass());
		return sysUsers.get(0);
	}

	/**
	 * 获取用户信息通过用户的uuid
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 09:49:52
	 * @param uuid
	 * @return
	 *
	 */
	public SysUserInfo getSysUserInfoByUserUuid(String uuid) {
		String hsql = "FROM SysUserInfo WHERE userUuid=:userUuid";
		TypedQuery<SysUserInfo> query = getEntityManager().createQuery(hsql, SysUserInfo.class);
		query.setParameter("userUuid", uuid);
		List<SysUserInfo> sysUserInfos = query.getResultList();
		return sysUserInfos.size() > 0 ? sysUserInfos.get(0) : null;
	}

	/**
	 * 查询用户
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 09:56:36
	 * @return
	 *
	 */
	public PageInfo querySysUser() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("SysUserQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<UserFormBean>(UserFormBean.class));
	}

	/**
	 * 清理用户-角色关联
	 * 
	 * @author Sun Rising
	 * @date 2019.06.29 09:15:54
	 * @param uuid
	 *
	 */
	public void cleanUserRoleByUserUuid(String userUuid) {
		final String jpq = "delete from SysUserRole where userUuid=:userUuid";
		Query query = super.getEntityManager().createQuery(jpq);
		query.setParameter("userUuid", userUuid);
		query.executeUpdate();
	}

	/**
	 * 获取用户-角色关联 通过用户UUID
	 * 
	 * @author Sun Rising
	 * @date 2019.06.29 09:35:21
	 * @param uuid
	 * @return
	 *
	 */
	public List<SysUserRole> getUserRoleByUserUuid(String userUuid) {
		String hsql = "FROM SysUserRole WHERE userUuid=:userUuid";
		TypedQuery<SysUserRole> query = getEntityManager().createQuery(hsql, SysUserRole.class);
		query.setParameter("userUuid", userUuid);
		return query.getResultList();
	}
}
