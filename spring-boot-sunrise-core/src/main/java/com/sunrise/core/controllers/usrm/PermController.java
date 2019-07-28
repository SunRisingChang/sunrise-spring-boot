package com.sunrise.core.controllers.usrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.entitys.SysPerm;
import com.sunrise.core.services.usrm.PermService;

/**
 * 权限管理
 * 
 * @author Sun Rising
 * @date 2019.06.27 08:59:01
 *
 */
@RestController
@RequestMapping("usrm/permMgr")
public class PermController extends BaseController {

	@Autowired
	private PermService permService;

	/**
	 * 保存或更新权限
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:28:34
	 * @param list
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveSysPerm")
	@LogOper(message = "保存或修改权限")
	public void saveSysPerm(@RequestBody SysPerm sysPerm) throws Exception {
		permService.saveSysPerm(sysPerm);
	}

	/**
	 * 获取权限列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:04
	 * @return
	 *
	 */
	@GetMapping("/querySysPerm")
	@LogOper(message = "查询权限列表")
	public Object querySysPerm() {
		return permService.querySysPerm();
	}

	/**
	 * 删除权限
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:24
	 * @param uuids uuid数组
	 *
	 */
	@DeleteMapping("/delSysPerm/{uuid}")
	@LogOper(message = "删除权限")
	public void delSysPerm(@PathVariable("uuid") String[] uuids) {
		permService.delSysPerm(uuids);
	}

	/**
	 * 获取所有的权限资源
	 * 
	 * @author Sun Rising
	 * @date 2019.06.27 09:46:53
	 * @return
	 *
	 */
	@GetMapping("/getPermMap")
	@LogOper(message = "获取权限Map")
	public Object getPermMap() {
		return permService.getPermMap();
	}
}
