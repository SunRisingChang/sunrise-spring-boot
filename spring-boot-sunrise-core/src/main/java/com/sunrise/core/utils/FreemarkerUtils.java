package com.sunrise.core.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 使用 freemarker处理模板
 * 
 * @author Sun Rising
 * @date 2018.12.25 02:54:40
 *
 */
@Component
public class FreemarkerUtils implements InitializingBean {

	private final Logger logger = LoggerFactory.getLogger(FreemarkerUtils.class);

	// freemarker配置对象
	private Configuration freemarkerCfg = new Configuration(Configuration.VERSION_2_3_28);

	// 模板转换时使用的临时模板名称
	final private String TEMPLATE_NAME = "sunrise";

	final private String CHAR_ENCOD = "UTF-8";

	/**
	 * freemarker初始化
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 04:58:12
	 * @throws Exception
	 *
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		freemarkerCfg.setDefaultEncoding(CHAR_ENCOD);
		// 不要在FreeMarker中记录它会抛出的异常：
		freemarkerCfg.setLogTemplateExceptions(false);
	}

	/**
	 * 结合map和模板流获取最终内容
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 06:25:52
	 * @param mapData     参数对象
	 * @param inputStream 数据流
	 * @return
	 *
	 */
	public String getContextTemplate(InputStream inputStream, Map<String, Object> mapData) {
		StringWriter stringWriter = new StringWriter();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		try (StringWriter stringWriter_t = stringWriter; InputStreamReader inputStreamReader_t = inputStreamReader;) {
			Template template = new Template(TEMPLATE_NAME, inputStreamReader, freemarkerCfg);
			template.process(mapData, stringWriter);
		} catch (Throwable e) {
			logger.error("freemarker template 转换失败...", e);
			return null;
		}
		return stringWriter.toString();
	}

	/**
	 * 结合map和字符串模板获取最终内容
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 06:57:10
	 * @param mapData
	 * @param inputStr
	 * @return
	 *
	 */
	public String getContextTemplate(String inputStr, Map<String, Object> mapData) {
		StringWriter stringWriter = new StringWriter();
		try (StringWriter stringWriter_t = stringWriter) {
			StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
			stringTemplateLoader.putTemplate(TEMPLATE_NAME, inputStr);
			freemarkerCfg.setTemplateLoader(stringTemplateLoader);
			Template template = freemarkerCfg.getTemplate(TEMPLATE_NAME);
			template.process(mapData, stringWriter);
		} catch (Throwable e) {
			logger.error("freemarker template 转换失败...", e);
			return null;
		}
		return stringWriter.toString();
	}

	/**
	 * 根据系统默认上下文参数和模板流获取最终内容
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 07:00:32
	 * @param instream 模板流
	 * @return
	 *
	 */
	public String getContextTemplate(InputStream instream) {
		return getContextTemplate(instream, SpringWebUtils.getInterActionRequestsMap());
	}

	/**
	 * 根据系统默认上下文参数和模板字符串获取最终内容
	 * 
	 * @author Sun Rising
	 * @date 2018.12.25 07:03:36
	 * @param inputStr 模板字符串
	 * @return
	 *
	 */
	public String getContextTemplate(String inputStr) {
		return getContextTemplate(inputStr, SpringWebUtils.getInterActionRequestsMap());
	}
}
