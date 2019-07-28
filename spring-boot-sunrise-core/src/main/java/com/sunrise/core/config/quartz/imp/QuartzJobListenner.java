package com.sunrise.core.config.quartz.imp;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;
import com.sunrise.core.entitys.LogQuartz;
import com.sunrise.core.services.logs.QuartzLogService;
import com.sunrise.core.services.sysm.QuartzService;
import com.sunrise.core.utils.CommonUtils;
import com.sunrise.core.utils.SpringContextUtils;

/**
 * job监听器
 * 
 * @author Sun_Rising
 * @date 2018.12.27 01:55:17
 *
 */
@Component
public class QuartzJobListenner implements JobListener {

	// 监听器名称
	private static final String LISTENER_NAME = "customJobListener";

	private static final String JOB_CURR_TIME = "JobCurrTime";

	// 日志级别，系统记录
	private static final String LOG_LEVE = "1";

	@Override
	public String getName() {
		return LISTENER_NAME;
	}

	/**
	 * Scheduler 在 JobDetail 将要被执行时调用这个方法。
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:56:48
	 * @param context
	 *
	 */
	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		context.put(JOB_CURR_TIME, System.currentTimeMillis());
	}

	/**
	 * Scheduler 在 JobDetail 即将被执行，但又被 TriggerListener 否决了时调用这个方法。
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:57:08
	 * @param context
	 *
	 */
	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
	}

	/**
	 * Scheduler 在 JobDetail 被执行之后调用这个方法。
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 01:57:28
	 * @param context
	 * @param jobException
	 *
	 */
	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		QuartzLogService quartzLogService = (QuartzLogService) SpringContextUtils.getBean("quartzLogService");
		JobKey jobKey = context.getJobDetail().getKey();
		LogQuartz logQuartz = new LogQuartz();
		logQuartz.setQtzName(jobKey.getName());
		logQuartz.setQtzGroup(jobKey.getGroup());
		logQuartz.setLogLeve(LOG_LEVE);
		logQuartz.setStartTime((Long) context.get(JOB_CURR_TIME));
		logQuartz.setProcTime(System.currentTimeMillis() - (Long) context.get(JOB_CURR_TIME));
		logQuartz.setSvrName(CommonUtils.getServerName());
		logQuartz.setSvrAddr(CommonUtils.getServerIP());
		if (jobException != null) {
			logQuartz.setExecInfo(jobException.getMessage());
			QuartzService quartzService = (QuartzService) SpringContextUtils.getBean("quartzService");
			quartzService.pauseSysQuartzByError(jobKey, jobException.getMessage());
		}
		quartzLogService.saveLogQuartz(logQuartz);
	}
}
