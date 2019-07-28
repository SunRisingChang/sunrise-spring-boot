package com.sunrise.core.controllers.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.services.logs.QuartzLogService;

/**
 * Quartz日志管理
 * 
 * @author Sun Rising
 * @date 2019.07.03 09:24:08
 *
 */
@RestController
@RequestMapping("/logs/quartzMgr")
public class QuartzLogController extends BaseController {

	@Autowired
	private QuartzLogService quartzLogService;

	/**
	 * 查询Quartz日志
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:46:28
	 * @return
	 *
	 */
	@GetMapping("/queryLogQuartz")
	@LogOper(message = "查询任务日志")
	public Object queryLogQuartz() {
		return quartzLogService.queryLogQuartz();
	}
}
