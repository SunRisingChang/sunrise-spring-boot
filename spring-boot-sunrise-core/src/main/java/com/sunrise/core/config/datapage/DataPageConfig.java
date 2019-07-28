package com.sunrise.core.config.datapage;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import com.sunrise.core.utils.page.DataPageUtils;
import com.sunrise.core.utils.page.factory.handle.DataBaseHandle;
import com.sunrise.core.utils.page.factory.handle.DataBaseType;

/**
 * 分页工具初始化类
 * 
 * @author Sun Rising
 * @date 2019.05.29 02:04:04
 *
 */
@Configuration
public class DataPageConfig {

	private Logger logger = LoggerFactory.getLogger(DataPageConfig.class);

	@Autowired
	public JdbcTemplate jdbcTemplate;

	/**
	 * 初始化全局数据库分页处理器
	 * 
	 * @author Sun Rising
	 * @date 2019.05.29 10:15:01
	 * @return
	 *
	 */
	@Bean
	public DataBaseHandle DataBaseFactory() {
		try {
			// 获取当前数据库类型
			String dbType = jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductName();
			DataBaseType dbTypeString = DataBaseType.findTypeEnumByKey(dbType);
			DataBaseHandle dataBaseHandle = DataPageUtils.getDataPageUtils(dbTypeString);
			return dataBaseHandle;
		} catch (SQLException e) {
			logger.error("[DataPageConfig]未获取到数据源类型. -[" + this.getClass());
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error("[DataPageConfig]未找到支持的数据库分页处理器. -[" + this.getClass());
			throw new RuntimeException(e.getMessage());
		}
	}
}
