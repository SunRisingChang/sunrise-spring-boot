package com.sunrise.core.daos.usrm;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.SysRole;
import com.sunrise.core.entitys.SysRolePerm;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 权限管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 11:43:32
 *
 */
@Repository
public class RoleDao extends BaseDao {

	/**
	 * 获取菜单列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:31:01
	 * @return
	 *
	 */
	public PageInfo querySysRole() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("SysRoleQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<SysRole>(SysRole.class));
	}

	/**
	 * 删除角色资源关联信息
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 09:48:50
	 * @param permUuid
	 *
	 */
	public void cleanRolePerm(String roleUuid, String permUuid) {
		final String jpq2 = "delete from SysRolePerm where roleUuid=:roleUuid and permUuid=:permUuid";
		Query query2 = super.getEntityManager().createQuery(jpq2);
		query2.setParameter("roleUuid", roleUuid);
		query2.setParameter("permUuid", permUuid);
		query2.executeUpdate();
	}

	/**
	 * 通过角色UUID和权限UUID获取资源主键集合
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 10:44:53
	 * @param roleUuid
	 * @param uuid
	 * @return
	 *
	 */
	public List<String> getRolePermRoseUuidsByRoleUuidAndPermUuid(String roleUuid, String permUuid) {
		final String jpql = "from SysRolePerm where roleUuid=:roleUuid and permUuid=:permUuid";
		TypedQuery<SysRolePerm> query = super.getEntityManager().createQuery(jpql, SysRolePerm.class);
		query.setParameter("roleUuid", roleUuid);
		query.setParameter("permUuid", permUuid);
		List<SysRolePerm> sysRolePerms = query.getResultList();
		List<String> list = new ArrayList<String>();
		for (SysRolePerm sysRolePerm : sysRolePerms) {
			list.add(sysRolePerm.getResoUuid());
		}
		return list;
	}

	/**
	 * 通过组织机构UUID获取角色
	 * 
	 * @author Sun Rising
	 * @date 2019.06.29 07:27:44
	 * @param orgUuid
	 * @return
	 *
	 */
	public List<SysRole> getRoleByOrgUuid(String orgUuid) {
		final String jpql = "from SysRole where orgUuid=:orgUuid";
		TypedQuery<SysRole> query = super.getEntityManager().createQuery(jpql, SysRole.class);
		query.setParameter("orgUuid", orgUuid);
		return query.getResultList();
	}
}
