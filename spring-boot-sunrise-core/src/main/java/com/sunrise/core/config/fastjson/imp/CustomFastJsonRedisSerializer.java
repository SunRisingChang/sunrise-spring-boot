package com.sunrise.core.config.fastjson.imp;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Fast-Redis转换器
 * 
 * @author Sun Rising
 * @date 2019.06.08 08:20:56
 *
 */
@Component
public class CustomFastJsonRedisSerializer implements RedisSerializer<Object> {

	final private String CHAR_ENCOD = "UTF-8";
	static {
		// 添加类型匹配的包白名单
		ParserConfig.getGlobalInstance().addAccept(".*.*entity*");
		// 开启类型匹配，支持@type
		ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
	}

	@Override
	public byte[] serialize(Object t) throws SerializationException {
		try {
			if (t == null) {
				return new byte[0];
			}
			return JSON.toJSONBytes(t, SerializerFeature.WriteClassName);
		} catch (Exception ex) {
			throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
		}
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		try {
			if (bytes == null || bytes.length == 0) {
				return null;
			}
			return JSON.parse(new String(bytes, CHAR_ENCOD));
		} catch (Exception ex) {
			throw new SerializationException("Could not deserialize: " + ex.getMessage(), ex);
		}
	}
}
