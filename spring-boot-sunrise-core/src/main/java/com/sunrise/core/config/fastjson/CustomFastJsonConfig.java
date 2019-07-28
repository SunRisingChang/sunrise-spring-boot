package com.sunrise.core.config.fastjson;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;

/**
 * fastjson格式化规则配置
 * 
 * @author Sun Rising
 * @date 2019.06.08 11:23:16
 *
 */
@Configuration
public class CustomFastJsonConfig {

	/**
	 * 格式化类型配置
	 * 
	 * @author Sun Rising
	 * @date 2019.06.15 08:16:31
	 * @return
	 *
	 */
	@Bean
	public FastJsonConfig customFastJsonFormat() {
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(
				// 是否输出值为null的字段,默认为false
				SerializerFeature.WriteMapNullValue,
				// Boolean字段如果为null,输出为false,而非null
				SerializerFeature.WriteNullBooleanAsFalse,
				// List字段如果为null,输出为[],而非null
				SerializerFeature.WriteNullListAsEmpty,
				// 输出key时是否使用双引号,默认为true
				SerializerFeature.QuoteFieldNames,
				// Enum输出name()或者original,默认为false
				SerializerFeature.WriteEnumUsingToString,
				// 字符类型字段如果为null,输出为"",而非null
				SerializerFeature.WriteNullStringAsEmpty,
				// 全局修改日期格式,默认为false。JSON.DEFFAULT_DATE_FORMAT = “yyyy-MM-dd”;
				SerializerFeature.WriteDateUseDateFormat,
				// 消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环
				SerializerFeature.DisableCircularReferenceDetect);
		return config;
	}

	/**
	 * 支持媒体类型配置
	 * 
	 * @author Sun Rising
	 * @date 2019.06.15 08:19:24
	 * @return
	 *
	 */
	@Bean
	public List<MediaType> customFastJsonMediaTypes() {
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		mediaTypes.add(MediaType.APPLICATION_ATOM_XML);
		mediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		mediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
		mediaTypes.add(MediaType.APPLICATION_PDF);
		mediaTypes.add(MediaType.APPLICATION_RSS_XML);
		mediaTypes.add(MediaType.APPLICATION_XHTML_XML);
		mediaTypes.add(MediaType.APPLICATION_XML);
		mediaTypes.add(MediaType.IMAGE_GIF);
		mediaTypes.add(MediaType.IMAGE_JPEG);
		mediaTypes.add(MediaType.IMAGE_PNG);
		mediaTypes.add(MediaType.TEXT_EVENT_STREAM);
		mediaTypes.add(MediaType.TEXT_HTML);
		mediaTypes.add(MediaType.TEXT_MARKDOWN);
		mediaTypes.add(MediaType.TEXT_PLAIN);
		mediaTypes.add(MediaType.TEXT_XML);
		return mediaTypes;
	}
}
