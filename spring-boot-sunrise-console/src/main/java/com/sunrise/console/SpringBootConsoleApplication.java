package com.sunrise.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 这个类要是不认识的话，劝你还是回去重头学习spring boot吧！
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:20:58
 *
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
//扫描全部Jar中com.sunrise包下的配置类
@ComponentScan(basePackages = { "com.sunrise" })
public class SpringBootConsoleApplication {

	/**
	 * 这个方法不认识，回去重新学java
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:22:14
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}
}
