package com.sunrise.core.daos.usrm;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.controllers.usrm.form.UserFormBean;
import com.sunrise.core.entitys.SysUserInfo;
import com.sunrise.core.entitys.SysUserRole;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 用户管理
 * 
 * @author Sun Rising
 * @date 2019.06.19 08:33:44
 *
 */
@Repository
public class UserDao extends BaseDao {

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
