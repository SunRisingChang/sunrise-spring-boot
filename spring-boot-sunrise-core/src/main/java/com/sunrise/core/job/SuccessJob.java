package com.sunrise.core.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sunrise.core.config.quartz.iface.TimeJob;

@Component
public class SuccessJob implements TimeJob {

	@Autowired
	private Test test;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("大吉大利，今晚吃鸡!");
//		int a = 1 / 0;
		test.say("大吉大利，今晚吃鸡!");
	}
}
