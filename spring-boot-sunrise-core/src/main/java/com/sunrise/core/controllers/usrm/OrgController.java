package com.sunrise.core.controllers.usrm;

import java.util.List;
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
import com.sunrise.core.entitys.SysOrg;
import com.sunrise.core.services.usrm.OrgService;

/***
 * 组织管理
 * 
 * @author Sun Rising
 * @date 2019.06.25 11:25:32
 *
 */
@RestController
@RequestMapping("/usrm/orgMgr")
public class OrgController extends BaseController {

	@Autowired
	private OrgService orgService;

	/**
	 * 保存或更新组织
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:28:34
	 * @param list
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveSysOrg")
	@LogOper(message = "保存或修改组织")
	public void saveSysOrg(@RequestBody List<SysOrg> list) throws Exception {
		orgService.saveSysOrg(list);
	}

	/**
	 * 获取组织列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:04
	 * @return
	 *
	 */
	@GetMapping("/getSysOrg")
	@LogOper(message = "获取组织列表")
	public Object getSysOrg() {
		return orgService.getSysOrg();
	}

	/**
	 * 删除组织
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:24
	 * @param uuids uuid数组
	 *
	 */
	@DeleteMapping("/delSysOrg/{uuid}")
	@LogOper(message = "删除组织")
	public void delSysOrg(@PathVariable("uuid") String[] uuids) {
		orgService.delSysOrg(uuids);
	}

	/**
	 * 获取可用的组织树集合,用于select
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:04
	 * @return
	 * @throws Exception
	 *
	 */
	@GetMapping("/getOrgTree")
	@LogOper(message = "获取组织树")
	public Object getOrgTree() throws Exception {
		return orgService.getOrgTree();
	}
}
