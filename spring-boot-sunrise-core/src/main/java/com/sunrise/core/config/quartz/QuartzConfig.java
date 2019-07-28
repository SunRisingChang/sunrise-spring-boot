package com.sunrise.core.config.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sunrise.core.config.quartz.imp.QuartzJobListenner;
import lombok.extern.slf4j.Slf4j;

/**
 * Quartz配置类
 * 
 * @author Sun Rising
 * @date 2019.07.03 09:16:59
 *
 */
@Slf4j
@Configuration
public class QuartzConfig {

	@Autowired
	private Scheduler scheduler;

	@Bean
	public void putListenerManager() {
		try {
			this.scheduler.getListenerManager().addJobListener(new QuartzJobListenner());
		} catch (SchedulerException e) {
			log.error("Quartz监听器添加失败");
		}
	}
}
