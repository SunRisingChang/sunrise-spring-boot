package com.sunrise.core.daos.sysm;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.sunrise.core.base.BaseDao;
import com.sunrise.core.entitys.SysFile;
import com.sunrise.core.utils.page.entitys.PageInfo;

/**
 * 系统文件
 * 
 * @author Sun Rising
 * @date 2019.07.09 08:39:43
 *
 */
@Repository
public class FileDao extends BaseDao {

	/**
	 * 查询文件
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 09:06:24
	 * @return
	 *
	 */
	public PageInfo querySysFile() {
		final String sqlStr = getFreemarkerUtils().getContextTemplate(this.getClass().getResourceAsStream("SysFileQuery.sql"));
		return sqlPage(sqlStr, new BeanPropertyRowMapper<SysFile>(SysFile.class));
	}

	/**
	 * 获取系统文件通过MD5
	 * 
	 * @author Sun Rising
	 * @date 2019.07.09 10:16:09
	 * @param md5
	 * @return
	 *
	 */
	public SysFile getSysFileByMd5(String fileMd5) {
		final String jpql = "from SysFile where fileMd5=:fileMd5";
		TypedQuery<SysFile> query = super.getEntityManager().createQuery(jpql, SysFile.class);
		query.setParameter("fileMd5", fileMd5);
		List<SysFile> list = query.getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
}
