package com.sunrise.core.job;

import org.springframework.stereotype.Component;

@Component
public class Test {
	
	public void say(String str) {
		System.out.println("我是通过注解注入的方法. 传递参数为:" + str);
	}

}
