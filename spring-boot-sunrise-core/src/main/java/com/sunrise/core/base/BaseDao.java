package com.sunrise.core.base;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.sunrise.core.config.ehcache.imp.CacheService;
import com.sunrise.core.entitys.SysUser;
import com.sunrise.core.utils.FreemarkerUtils;
import com.sunrise.core.utils.SpringWebUtils;
import com.sunrise.core.utils.page.entitys.PageInfo;
import com.sunrise.core.utils.page.factory.handle.DataBaseHandle;
import lombok.Getter;

/**
 * 所有的Dao层都要继承该类
 * 
 * @author Sun_Rising
 * @date 2018.12.27 01:47:10
 *
 */
@Getter
public class BaseDao {

	private Logger logger = LoggerFactory.getLogger(BaseDao.class);

	@Autowired
	private CacheService cacheService;

	// 实体管理器
	@PersistenceContext
	private EntityManager entityManager;

	// JdbcTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Freemarker模板解析工具
	@Autowired
	private FreemarkerUtils freemarkerUtils;

	// 数据库SQL分页工具
	@Autowired
	private DataBaseHandle pageUtils;

	/**
	 * 分页方法 返回数据库原生字段集合
	 * 
	 * @author Sun Rising
	 * @date 2019.05.29 02:26:53
	 * @param sql
	 * @return
	 *
	 */
	public PageInfo sqlPage(final String sql) {
		return sqlPage(sql, new ColumnMapRowMapper());
	}

	/**
	 * 分页方法 返回指定实体集合
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 04:53:18
	 * @param sql
	 * @param rowMapper
	 * @return
	 *
	 */
	public <T> PageInfo sqlPage(final String sql, RowMapper<T> rowMapper) {
		// 数据页封装类
		PageInfo pageInfo = new PageInfo();
		// 先装配数据页封装类，pageUtils.getPageSql会读取
		try {
			BeanUtils.copyProperties(pageInfo, SpringWebUtils.getInterActionRequestsMap());
		} catch (Exception e) {
			logger.error("[DataPage]分页数据 copyProperties 失败. -[" + this.getClass());
		}
		// 获取总页数SQL
		String totalRecordsSql = pageUtils.getTotalRecords(sql);
		// 查询总页数
		int totalRecords = jdbcTemplate.queryForObject(totalRecordsSql, Integer.class);
		// 设置总页数
		pageInfo.setTotalRecords(totalRecords);
		// 获取分页SQL
		String pageSql = pageUtils.getPageSql(sql, pageInfo);
		// 执行查询
		List<T> provSends = jdbcTemplate.query(pageSql, rowMapper);
		// 设置返回结果集
		pageInfo.setDataBody(provSends);
		return pageInfo;
	}

	/**
	 * 写入公共常量并更新实例
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 07:22:59
	 * @param object
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 *
	 */
	public void mergeAutoWriteMsg(Object object) throws Exception {
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		BeanUtils.setProperty(object, "updatedUser", sysUser.getUuid());
		BeanUtils.setProperty(object, "updatedTime", System.currentTimeMillis());
		entityManager.merge(object);
	}

	/**
	 * 写入公共常量并新增实例
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 07:23:45
	 * @param object
	 * @throws @throws Exception
	 *
	 */
	public void persistAutoWriteMsg(Object object) throws Exception {
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		BeanUtils.setProperty(object, "createdUser", sysUser.getUuid());
		BeanUtils.setProperty(object, "createdTime", System.currentTimeMillis());
		BeanUtils.setProperty(object, "updatedUser", sysUser.getUuid());
		BeanUtils.setProperty(object, "updatedTime", System.currentTimeMillis());
		entityManager.persist(object);
	}

	/**
	 * 字段唯一性检查，通用方法
	 * 
	 * @author Sun Rising
	 * @throws Exception
	 * @date 2019.06.26 04:45:19
	 *
	 */
	public boolean checkUnique(Object target, String field) throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from ");
		stringBuffer.append(target.getClass().getSimpleName());
		stringBuffer.append(" where ");
		stringBuffer.append(field);
		stringBuffer.append(" = :");
		stringBuffer.append(field);
		String targetUuid = BeanUtils.getProperty(target, "uuid");
		if (StringUtils.isNotBlank(targetUuid)) {
			stringBuffer.append(" and uuid <> '");
			stringBuffer.append(BeanUtils.getProperty(target, "uuid"));
			stringBuffer.append("'");
		}
		Query query = getEntityManager().createQuery(stringBuffer.toString());
		query.setParameter(field, BeanUtils.getProperty(target, field));
		List<?> list = query.getResultList();
		return list.size() == 0;
	}
}
