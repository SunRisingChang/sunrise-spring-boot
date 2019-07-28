package com.sunrise.core.controllers.sysm;

import org.apache.commons.lang3.StringUtils;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.controllers.sysm.form.QuartzFormBean;
import com.sunrise.core.services.sysm.QuartzService;

/**
 * quartz任务管理
 * 
 * @Description
 * @Author Sun_Rising
 * @Date 2018年8月7日 Copyright (c) All Rights Reserved, 2018.
 *
 *
 */
@RestController
@RequestMapping(path = "/sysm/quartzMgr")
public class QuartzController extends BaseController {

	@Autowired
	private QuartzService quartzService;

	/**
	 * 查询quartz
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 09:10:09
	 * @return
	 * @throws SchedulerException
	 *
	 */
	@GetMapping("/querySysQuartz")
	@LogOper(message = "查询定时任务")
	public Object querySysQuartz() {
		return quartzService.querySysQuartz();
	}

	/**
	 * 保存任务
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 01:01:16
	 * @param quartzFormBean
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveSysQuartz")
	@LogOper(message = "保存或修改定时任务")
	public void saveSysQuartz(@RequestBody QuartzFormBean quartzFormBean) throws Exception {
		quartzService.saveSysQuartz(quartzFormBean);
	}

	/**
	 * 删除任务
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 02:47:30
	 * @param jobkeys
	 * @return
	 * @throws Exception
	 *
	 */
	@DeleteMapping("/delSysQuartz/{uuids}")
	@LogOper(message = "删除定时任务")
	public void delSysQuartz(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0)
			quartzService.delSysQuartz(uuids);
	}

	/**
	 * 批量运行任务
	 * 
	 * @Description QuartzController > runJob
	 * @Author Sun_Rising
	 * @Date 2018年8月10日
	 * @param jobkeys
	 * @return
	 * @throws Exception
	 *
	 *
	 */
	@PutMapping("/resumeSysQuartz/{uuids}")
	@LogOper(message = "运行定时任务")
	public void resumeSysQuartz(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0) {
			quartzService.resumeSysQuartz(uuids);
		}
	}

	/**
	 * 批量暂停任务
	 * 
	 * @Description QuartzController > stopJob
	 * @Author Sun_Rising
	 * @Date 2018年8月10日
	 * @param jobkeys
	 * @return
	 * @throws Exception
	 *
	 *
	 */
	@PutMapping("/pauseSysQuartz/{uuids}")
	@LogOper(message = "暂停定时任务")
	public void pauseSysQuartz(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0) {
			quartzService.pauseSysQuartz(uuids);
		}
	}

	/**
	 * 获取JOB详情
	 * 
	 * @Description QuartzController > loadJobInfo
	 * @Author Sun_Rising
	 * @Date 2018年8月13日
	 * @param jobName
	 * @return
	 * @throws Exception
	 * @throws SchedulerException
	 *
	 *
	 */
	@GetMapping("/getSysQuartzJobInfo")
	@LogOper(message = "获取定时任务信息")
	public Object getSysQuartzJobInfo(String uuid) throws Exception {
		if (StringUtils.isNotBlank(uuid)) {
			return quartzService.getSysQuartzJobInfo(uuid);
		}
		return null;
	}

	/**
	 * 获取项目中实现Job的类
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 10:41:01
	 * @return
	 *
	 */
	@GetMapping("/getJobClass")
	@LogOper(message = "获取定时任务实现类列表")
	public Object getJobClass() {
		return quartzService.getJobClass();
	}
}
