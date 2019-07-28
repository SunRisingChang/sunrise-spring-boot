package com.sunrise.core.config.ehcache.imp;

import javax.cache.Cache;
import javax.cache.CacheManager;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class CacheService {

	private CacheManager cacheManager;

	private Cache<String, Object> localCache;

	public CacheService(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
		localCache = this.cacheManager.getCache("localCache", String.class, Object.class);
	}
}
