package com.sunrise.core.daos.app;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.SysMenu;
import com.sunrise.core.entitys.SysPerm;
import com.sunrise.core.entitys.SysRolePerm;
import com.sunrise.core.entitys.SysUserRole;
import com.sunrise.core.utils.UnderlineToCamelUtils;

/**
 * 账户管理
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:16:44
 *
 */
@Repository
public class AccountDao extends BaseDao {

	/**
	 * 获取用户和角色的关联，通过用户uuid
	 * 
	 * @author Sun Rising
	 * @date 2019.05.30 12:15:04
	 * @param userId
	 * @return
	 *
	 */
	public List<SysUserRole> getSysUserRoleByUserId(String userId) {
		String jpql = "FROM SysUserRole WHERE userUuid=:userId";
		TypedQuery<SysUserRole> query = getEntityManager().createQuery(jpql, SysUserRole.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	/**
	 * 获取权限和角色的关联，通过角色uuid
	 * 
	 * @author Sun Rising
	 * @date 2019.05.30 12:57:49
	 * @param roleId
	 * @return
	 *
	 */
	public List<SysRolePerm> getSysRolePermByRoleId(String roleId) {
		String jpql = "FROM SysRolePerm WHERE roleUuid=:roleId";
		TypedQuery<SysRolePerm> query = getEntityManager().createQuery(jpql, SysRolePerm.class);
		query.setParameter("roleId", roleId);
		return query.getResultList();
	}

	/**
	 * 获取用户的可用菜单
	 * 
	 * @author Sun Rising
	 * @date 2019.06.30 09:35:59
	 * @param userUuid
	 * @return
	 *
	 */
	public List<SysMenu> getAvailableMenu(String userUuid) {
		List<SysMenu> sysMenus = new ArrayList<SysMenu>();
		String jpql = "FROM SysUserRole WHERE userUuid=:userUuid";
		TypedQuery<SysUserRole> query = getEntityManager().createQuery(jpql, SysUserRole.class);
		query.setParameter("userUuid", userUuid);
		List<SysUserRole> sysUserRoles = query.getResultList();
		for (SysUserRole sysUserRole : sysUserRoles) {
			String jpql2 = "FROM SysRolePerm WHERE roleUuid=:roleUuid";
			TypedQuery<SysRolePerm> query2 = getEntityManager().createQuery(jpql2, SysRolePerm.class);
			query2.setParameter("roleUuid", sysUserRole.getRoleUuid());
			List<SysRolePerm> sysRolePerms = query2.getResultList();
			for (SysRolePerm sysRolePerm : sysRolePerms) {
				SysPerm sysPerm = getEntityManager().find(SysPerm.class, sysRolePerm.getPermUuid());
				String permTable = UnderlineToCamelUtils.underlineToCamel(sysPerm.getPermTable(), false);
				StringBuffer jpql3 = new StringBuffer();
				jpql3.append("FROM ");
				jpql3.append(permTable);
				jpql3.append(" WHERE uuid=:uuid");
				TypedQuery<SysMenu> query3 = getEntityManager().createQuery(jpql3.toString(), SysMenu.class);
				query3.setParameter("uuid", sysRolePerm.getResoUuid());
				List<SysMenu> sysMenu = query3.getResultList();
				if (sysMenu.size() == 1) {
					if (!sysMenus.contains(sysMenu.get(0)))
						sysMenus.add(sysMenu.get(0));
				}
			}
		}
		return sysMenus;
	}
}
