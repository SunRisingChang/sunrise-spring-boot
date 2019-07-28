package com.sunrise.core.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.sunrise.core.config.fastjson.imp.CustomFastJsonRedisSerializer;

/**
 * Redis配置类
 * 
 * @author Sun Rising
 * @date 2019.06.08 11:21:55
 *
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

	@Autowired
	private CustomFastJsonRedisSerializer customFastJsonRedisSerializer;

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setValueSerializer(customFastJsonRedisSerializer);
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		// 使用StringRedisSerializer来序列化和反序列化redis的ke
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		// 开启事务
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}
}