package com.sunrise.core.controllers.usrm;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.controllers.usrm.form.RoleFormBean;
import com.sunrise.core.services.usrm.RoleService;

/**
 * 角色管理
 * 
 * @author Sun Rising
 * @date 2019.06.27 08:59:13
 *
 */
@RestController
@RequestMapping("usrm/roleMgr")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	/**
	 * 保存或更新角色
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:28:34
	 * @param list
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveSysRole")
	@LogOper(message = "保存或修改角色")
	public void saveSysRole(RoleFormBean roleFormBean) throws Exception {
		roleService.saveSysRole(roleFormBean);
	}

	/**
	 * 获取角色列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:04
	 * @return
	 *
	 */
	@GetMapping("/querySysRole")
	@LogOper(message = "查询角色")
	public Object querySysRole() {
		return roleService.querySysRole();
	}

	/**
	 * 删除角色
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 05:29:24
	 * @param uuids uuid数组
	 *
	 */
	@DeleteMapping("/delSysRole/{uuid}")
	@LogOper(message = "删除角色")
	public void delSysRole(@PathVariable("uuid") String[] uuids) {
		roleService.delSysRole(uuids);
	}

	/**
	 * 获取已选择的资源信息
	 * 
	 * @author Sun Rising
	 * @date 2019.06.28 10:21:41
	 * @return
	 *
	 */
	@GetMapping("/getSelectPerm")
	@LogOper(message = "获取拥有的资源信息")
	public Object getSelectPerm(String roleUuid) {
		if (StringUtils.isNotBlank(roleUuid)) {
			return roleService.getSelectPerm(roleUuid);
		}
		return null;
	}

	/**
	 * 通过组织机构UUID获取角色
	 * 
	 * @author Sun Rising
	 * @date 2019.06.29 07:24:38
	 * @param orgUuid
	 * @return
	 *
	 */
	@GetMapping("/getRoleByOrgUuid")
	@LogOper(message = "获取拥有的角色")
	public Object getRoleByOrgUuid(String orgUuid) {
		if (StringUtils.isNotBlank(orgUuid)) {
			return roleService.getRoleByOrgUuid(orgUuid);
		}
		return new ArrayList<>();
	}
}
