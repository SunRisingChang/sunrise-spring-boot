package com.sunrise.core.daos.usrm;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.SysPerm;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 权限管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 11:43:32
 *
 */
@Repository
public class PermDao extends BaseDao {

	/**
	 * 获取菜单列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:31:01
	 * @return
	 *
	 */
	public PageInfo querySysPerm() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("SysPermQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<SysPerm>(SysPerm.class));
	}

	/**
	 * 获取全部可用的资源
	 * 
	 * @author Sun Rising
	 * @date 2019.06.27 09:53:37
	 * @return
	 *
	 */
	public List<SysPerm> getAvailSysPerm() {
		final String jpql = "from SysPerm where permStat=:permStat";
		TypedQuery<SysPerm> query = super.getEntityManager().createQuery(jpql, SysPerm.class);
		query.setParameter("permStat", "1");
		return query.getResultList();
	}

	/**
	 * 获取资源信息
	 * 
	 * @author Sun Rising
	 * @date 2019.06.27 09:59:16
	 * @return
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getPermInfo(String entityClassName) {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("from ");
		strBuffer.append(entityClassName);
		Query query = super.getEntityManager().createQuery(strBuffer.toString());
		return query.getResultList();
	}

	/**
	 * 检查指定表是否存在
	 * 
	 * @author Sun Rising
	 * @date 2019.06.27 11:41:00
	 * @param tableName
	 * @return
	 *
	 */
	public boolean checkTableExist(String tableName) {
		try {
			Connection connection = super.getEntityManager().unwrap(SessionImplementor.class).connection();
			DatabaseMetaData metaData = connection.getMetaData();
			ResultSet rs = metaData.getTables(connection.getCatalog(), null, tableName, new String[] { "TABLE" });
			return rs.next();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 通过权限类型获取权限对象
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 10:06:03
	 * @param permType
	 * @return
	 *
	 */
	public SysPerm getSysPermByPermType(String permType) {
		final String jpql = "from SysPerm where permType=:permType";
		TypedQuery<SysPerm> query = super.getEntityManager().createQuery(jpql, SysPerm.class);
		query.setParameter("permType", permType);
		List<SysPerm> list = query.getResultList();
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}
}
