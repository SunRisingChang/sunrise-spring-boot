package com.sunrise.core.daos.sysm;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.SysMenu;

/**
 * 菜单管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 05:28:16
 *
 */
@Repository
public class MenuDao extends BaseDao {

	/**
	 * 获取菜单列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:31:01
	 * @return
	 *
	 */
	public List<SysMenu> getSysMenu() {
		final String jpql = "from SysMenu";
		TypedQuery<SysMenu> query = super.getEntityManager().createQuery(jpql, SysMenu.class);
		return query.getResultList();
	}

	/**
	 * 获取当前路径下的所有子路径
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:31:15
	 * @param menuUrl 当前路径
	 * @return
	 *
	 */
	public List<SysMenu> getSysMenuChildren(String menuUrl) {
		final String jpql = "from SysMenu where menuParent=:menuParent";
		TypedQuery<SysMenu> query = super.getEntityManager().createQuery(jpql, SysMenu.class);
		query.setParameter("menuParent", menuUrl);
		return query.getResultList();
	}
}
