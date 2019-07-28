package com.sunrise.core.controllers.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.services.logs.OperLogService;

/**
 * 交互日志管理
 * 
 * @author Sun Rising
 * @date 2019.07.03 09:24:08
 *
 */
@RestController
@RequestMapping("/logs/operMgr")
public class OperLogController extends BaseController {

	@Autowired
	private OperLogService operLogService;

	/**
	 * 查询交互日志
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 12:46:28
	 * @return
	 *
	 */
	@GetMapping("/queryLogOper")
	@LogOper(message = "查询交互日志")
	public Object queryLogOper() {
		return operLogService.queryLogOper();
	}
}
