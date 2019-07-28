package com.sunrise.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 这个类要是不认识的话，劝你还是回去重头学习spring boot吧！
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:20:58
 *
 */
@SpringBootApplication
@EnableCaching
public class SpringBootCoreApplication {

	/**
	 * 这个方法不认识，回去重新学java
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:22:14
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreApplication.class, args);
	}
}
