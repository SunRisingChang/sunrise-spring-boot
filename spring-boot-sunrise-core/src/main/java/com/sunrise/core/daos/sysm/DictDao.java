package com.sunrise.core.daos.sysm;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.SysDictGroup;
import com.sunrise.core.entitys.SysDictItem;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 字典管理
 * 
 * @author Sun Rising
 * @date 2019.06.28 12:44:30
 *
 */
@Repository
public class DictDao extends BaseDao {

	/**
	 * 查询字典组
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:13:44
	 * @return
	 *
	 */
	public PageInfo querySysDictGroup() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("SysDictGroupQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<SysDictGroup>(SysDictGroup.class));
	}

	/**
	 * 查询select字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:13:55
	 * @return
	 *
	 */
	public PageInfo getSysDictSelectItem() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("SysDictSelectItemQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<SysDictItem>(SysDictItem.class));
	}

	/**
	 * 获取tree字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:14:24
	 * @param groupUuid
	 * @return
	 *
	 */
	public List<SysDictItem> getSysDictTreeItem(String groupUuid) {
		final String jpql = "from SysDictItem where groupUuid=:groupUuid";
		TypedQuery<SysDictItem> query = super.getEntityManager().createQuery(jpql, SysDictItem.class);
		query.setParameter("groupUuid", groupUuid);
		return query.getResultList();
	}

	/**
	 * 获取tree字典值
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 08:14:24
	 * @param groupUuid
	 * @return
	 *
	 */
	public List<SysDictItem> getSysDictItemByGroupKey(String groupKey) {
		final String jpql = "from SysDictGroup where groupKey=:groupKey";
		TypedQuery<SysDictGroup> query = super.getEntityManager().createQuery(jpql, SysDictGroup.class);
		query.setParameter("groupKey", groupKey);
		List<SysDictGroup> sysDictGroups = query.getResultList();
		SysDictGroup sysDictGroup = null;
		if (sysDictGroups.size() == 1) {
			sysDictGroup = sysDictGroups.get(0);
		} else {
			return new ArrayList<SysDictItem>();
		}
		final String jpql2 = "from SysDictItem where groupUuid=:groupUuid";
		TypedQuery<SysDictItem> query2 = super.getEntityManager().createQuery(jpql2, SysDictItem.class);
		query2.setParameter("groupUuid", sysDictGroup.getUuid());
		return query2.getResultList();
	}
}
