package com.sunrise.core.daos.usrm;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.SysOrg;

/**
 * 组织管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 11:27:39
 *
 */
@Repository
public class OrgDao extends BaseDao {

	/**
	 * 获取组织列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:31:01
	 * @return
	 *
	 */
	public List<SysOrg> getSysOrg() {
		final String jpql = "from SysOrg";
		TypedQuery<SysOrg> query = super.getEntityManager().createQuery(jpql, SysOrg.class);
		return query.getResultList();
	}

	/**
	 * 获取当前组织下的所有子组织
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:31:15
	 * @param menuUrl 当前路径
	 * @return
	 *
	 */
	public List<SysOrg> getSysOrgChildren(String orgCode) {
		final String jpql = "from SysOrg where orgPare=:orgPare";
		TypedQuery<SysOrg> query = super.getEntityManager().createQuery(jpql, SysOrg.class);
		query.setParameter("orgPare", orgCode);
		return query.getResultList();
	}

	/**
	 * 获取可用的组织树集合
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 08:59:28
	 * @return
	 *
	 */
	public List<SysOrg> getOrgTreeList() {
		final String jpql = "from SysOrg where orgStat=:orgStat";
		TypedQuery<SysOrg> query = super.getEntityManager().createQuery(jpql, SysOrg.class);
		query.setParameter("orgStat", "1");
		return query.getResultList();
	}
}
