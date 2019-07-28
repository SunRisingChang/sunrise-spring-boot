package com.sunrise.core.config.ehcache.imp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sunrise.core.config.websocket.dto.SoketMessage;
import com.sunrise.core.config.websocket.dto.SoketMsgConst;
import com.sunrise.core.config.websocket.imp.WebSoketService;
import com.sunrise.core.constant.SystemConst;

/**
 * 字典缓存服务类
 * 
 * @author Sun Rising
 * @date 2019.07.01 03:39:47
 *
 */
@Component
public class DictCacheService {

	@Autowired
	private CacheService cacheService;

	/**
	 * 移除字典缓存并发送长连接通知
	 * 
	 * @author Sun Rising
	 * @date 2019.07.01 04:05:00
	 * @param dictKey
	 * @throws Exception
	 *
	 */
	public void dictRemove(String dictKey) throws Exception {
		if (StringUtils.isNotBlank(dictKey)) {
			cacheService.getLocalCache().remove(SystemConst.DICT_CACHE_PREFIX + dictKey);
			SoketMessage soketMessage = new SoketMessage(SoketMsgConst.DICT_CHANGE);
			soketMessage.setValue(dictKey);
			soketMessage.setTimestamp(System.currentTimeMillis());
			WebSoketService.allSendMessage(soketMessage);
		}
	}
}
