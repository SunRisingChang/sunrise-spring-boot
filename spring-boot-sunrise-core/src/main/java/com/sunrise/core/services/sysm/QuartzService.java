package com.sunrise.core.services.sysm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.config.exception.CustomRuntimeException;
import com.sunrise.core.config.quartz.iface.TimeJob;
import com.sunrise.core.controllers.sysm.dto.QuartzJobInfo;
import com.sunrise.core.controllers.sysm.form.QuartzFormBean;
import com.sunrise.core.daos.sysm.QuartzDao;
import com.sunrise.core.entitys.SysQuartz;
import com.sunrise.core.utils.SpringContextUtils;
import com.sunrise.core.utils.page.entitys.PageInfo;
import lombok.extern.slf4j.Slf4j;

/***
 * Quartz定时任务管理
 * 
 * @author Sun Rising
 * @date 2019.07.01 10:00:02
 *
 */
@Slf4j
@Service
public class QuartzService extends BaseService {

	@Autowired
	private Scheduler scheduler;

	@Autowired
	private QuartzDao quartzDao;

	// job任务传递key
	public static final String JOB_PARAMS_KEY = "JOB_PARAMS_KEY";

	// job运行正常
	public static final String JOB_STAT_RUN = "1";

	// job运行停止
	public static final String JOB_STAT_PAUSE = "2";

	// job运行错误
	public static final String JOB_STAT_ERROR = "5";

	/**
	 * 查询quartz
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 09:12:12
	 * @return
	 *
	 */
	@Transactional
	public PageInfo querySysQuartz() {
		return quartzDao.querySysQuartz();
	}

	/**
	 * 保存任务数据
	 *
	 * @param quartzFormBean
	 * @throws Exception
	 * @Description QuartzService > saveJob
	 * @Author Sun_Rising
	 * @Date 2018年8月8日
	 */
	@Transactional
	public void saveSysQuartz(QuartzFormBean quartzFormBean) throws Exception {
		SysQuartz sysQuartz = new SysQuartz();
		BeanUtils.copyProperties(sysQuartz, quartzFormBean);
		if (StringUtils.isNotBlank(sysQuartz.getQuartzName())) {
			// 判重
			if (!quartzDao.checkUnique(sysQuartz, "quartzName")) {
				throw new CustomRuntimeException("任务名称重复");
			}
		}
		JobKey jobKey = JobKey.jobKey(quartzFormBean.getQuartzName(), quartzFormBean.getQuartzGroup());
		sysQuartz.setQuartzStat(quartzFormBean.isRun() ? JOB_STAT_RUN : JOB_STAT_PAUSE);
		sysQuartz.setQuartzExce(null);
		if (StringUtils.isNotBlank(sysQuartz.getUuid())) {
			this.delJob(jobKey);
			quartzDao.mergeAutoWriteMsg(sysQuartz);
		} else {
			quartzDao.persistAutoWriteMsg(sysQuartz);
		}
		this.createJob(quartzFormBean);
	}

	/**
	 * 创建job任务，内部调用
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 01:37:53
	 * @param quartzFormBean
	 * @throws Exception
	 *
	 */
	@Transactional
	private void createJob(QuartzFormBean quartzFormBean) throws Exception {
		TimeJob timeJob = SpringContextUtils.getBeanByFullClassName(quartzFormBean.getQuartzClass());
		Class<? extends TimeJob> cls = timeJob.getClass();
		JobKey jobKey = JobKey.jobKey(quartzFormBean.getQuartzName(), quartzFormBean.getQuartzGroup());
		// 构建job信息
		JobDetail job = JobBuilder.newJob(cls).withIdentity(jobKey).withDescription(quartzFormBean.getQuartzDesc()).storeDurably().build();
		// 传递配置参数
		if (StringUtils.isNotBlank(quartzFormBean.getQuartzParams())) {
			job.getJobDataMap().put(JOB_PARAMS_KEY, quartzFormBean.getQuartzParams());
		}
		scheduler.addJob(job, true);
		// 触发时间点
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartzFormBean.getQuartzCron());
		// 创建触发策略
		CronScheduleBuilder trigMisfire = cronScheduleBuilder.withMisfireHandlingInstructionDoNothing();
		if (StringUtils.isNotBlank(quartzFormBean.getQuartzMisfire())) {
			if ("2".equals(quartzFormBean.getQuartzMisfire())) {
				trigMisfire = cronScheduleBuilder.withMisfireHandlingInstructionFireAndProceed(); // 合并部分的misfire,正常执行下一个周期的任务
			}
			if ("3".equals(quartzFormBean.getQuartzMisfire())) {
				trigMisfire = cronScheduleBuilder.withMisfireHandlingInstructionIgnoreMisfires(); // 所有misfire的任务会马上执行
			}
		}
		// 创建触发器
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_" + quartzFormBean.getQuartzName(), "trigger_" + quartzFormBean.getQuartzGroup()).withSchedule(trigMisfire).withPriority(quartzFormBean.getQuartzPriority()).forJob(job).build();
		// 放入调度器
		scheduler.scheduleJob(trigger);
		// 是否立即启动
		if (!quartzFormBean.isRun()) {
			scheduler.pauseJob(jobKey);
		}
	}

	/**
	 * 删除任务
	 *
	 * @param jobkeys
	 * @throws Exception
	 * @Description QuartzService > delJob
	 * @Author Sun_Rising
	 * @Date 2018年8月8日
	 */
	@Transactional
	public void delSysQuartz(String[] uuids) throws Exception {
		for (String uuid : uuids) {
			SysQuartz sysQuartz = quartzDao.getEntityManager().find(SysQuartz.class, uuid);
			JobKey jobKey = JobKey.jobKey(sysQuartz.getQuartzName(), sysQuartz.getQuartzGroup());
			this.delJob(jobKey);
			quartzDao.getEntityManager().remove(sysQuartz);
		}
	}

	/**
	 * 删除任务 ，内部调用
	 *
	 * @param jobKey
	 * @param delHis
	 * @throws Exception
	 * @Description QuartzService > delJobPri
	 * @Author Sun_Rising
	 * @Date 2018年8月8日
	 */
	@Transactional
	private void delJob(JobKey jobKey) throws Exception {
		List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
		for (Trigger t : triggers) {
			scheduler.pauseTrigger(t.getKey());
			scheduler.unscheduleJob(t.getKey());
		}
		scheduler.deleteJob(jobKey);
	}

	/**
	 * 批量运行任务
	 *
	 * @param jobkeys
	 * @throws Exception
	 * @Description QuartzService > runJob
	 * @Author Sun_Rising
	 * @Date 2018年8月10日
	 */
	@Transactional
	public void resumeSysQuartz(String[] uuids) throws Exception {
		for (String uuid : uuids) {
			SysQuartz sysQuartz = quartzDao.getEntityManager().find(SysQuartz.class, uuid);
			JobKey jobKey = JobKey.jobKey(sysQuartz.getQuartzName(), sysQuartz.getQuartzGroup());
			scheduler.resumeJob(jobKey);
			sysQuartz.setQuartzStat(JOB_STAT_RUN);
			quartzDao.mergeAutoWriteMsg(sysQuartz);
		}
	}

	/**
	 * 批量暂停任务
	 *
	 * @param jobkeys
	 * @throws Exception
	 * @Description QuartzService > stopJob
	 * @Author Sun_Rising
	 * @Date 2018年8月10日
	 */
	@Transactional
	public void pauseSysQuartz(String[] uuids) throws Exception {
		for (String uuid : uuids) {
			SysQuartz sysQuartz = quartzDao.getEntityManager().find(SysQuartz.class, uuid);
			JobKey jobKey = JobKey.jobKey(sysQuartz.getQuartzName(), sysQuartz.getQuartzGroup());
			scheduler.pauseJob(jobKey);
			sysQuartz.setQuartzStat(JOB_STAT_PAUSE);
			quartzDao.mergeAutoWriteMsg(sysQuartz);
		}
	}

	/**
	 * 暂停任务因为错误
	 * 
	 * @author Sun Rising
	 * @date 2019.07.03 10:33:48
	 * @param jobKey
	 * @throws Exception
	 *
	 */
	@Transactional
	public void pauseSysQuartzByError(JobKey jobKey, String errorMsg) {
		try {
			scheduler.pauseJob(jobKey);
			SysQuartz sysQuartz = quartzDao.getSysQuartz(jobKey.getName(), jobKey.getGroup());
			sysQuartz.setQuartzStat(JOB_STAT_ERROR);
			sysQuartz.setQuartzExce(errorMsg);
			sysQuartz.setUpdatedTime(System.currentTimeMillis());
			quartzDao.getEntityManager().merge(sysQuartz);
		} catch (Exception e) {
			log.error("Quartz任务：" + jobKey.getName() + " , 因错误停止失败");
			// 触发事务回滚
			throw new RuntimeException("Quartz任务：" + jobKey.getName() + " , 因错误停止失败");
		}
	}

	/**
	 * 通过jobname获取job详情
	 *
	 * @param jobName
	 * @return
	 * @throws SchedulerException
	 * @Description QuartzService > loadJobInfo
	 * @Author Sun_Rising
	 * @Date 2018年8月14日
	 */
	@Transactional
	public QuartzJobInfo getSysQuartzJobInfo(String uuid) throws Exception {
		SysQuartz sysQuartz = quartzDao.getEntityManager().find(SysQuartz.class, uuid);
		JobKey jobKey = JobKey.jobKey(sysQuartz.getQuartzName(), sysQuartz.getQuartzGroup());
		if (scheduler.checkExists(jobKey)) {
			return quartzDao.getSysQuartzJobInfo(jobKey);
		}
		return new QuartzJobInfo();
	}

	/**
	 * 获取项目中实现aseJob的类
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 10:42:01
	 * @return
	 *
	 */
	public List<Map<String, String>> getJobClass() {
		List<Map<String, String>> viewJobs = new ArrayList<>();
		Map<String, TimeJob> joblist = SpringContextUtils.getApplicationContext().getBeansOfType(TimeJob.class);
		for (String i : joblist.keySet()) {
			Map<String, String> jMap = new HashMap<>();
			jMap.put("label", joblist.get(i).getClass().getName());
			jMap.put("value", i);
			viewJobs.add(jMap);
		}
		return viewJobs;
	}
}
