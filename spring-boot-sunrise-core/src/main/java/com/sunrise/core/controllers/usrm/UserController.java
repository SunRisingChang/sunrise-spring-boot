package com.sunrise.core.controllers.usrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.controllers.usrm.form.UserFormBean;
import com.sunrise.core.services.usrm.UserService;

/**
 * 用户管理
 * 
 * @author Sun Rising
 * @date 2019.06.19 08:36:19
 *
 */
@RestController
@RequestMapping("/usrm/userMgr")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 查询用户列表
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 09:36:52
	 * @return
	 *
	 */
	@GetMapping("/querySysUser")
	@LogOper(message = "查询用户")
	public Object querySysUser() {
		return userService.querySysUser();
	}

	/**
	 * 保存用户
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 09:37:13
	 * @param userFormBean
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveSysUser")
	@LogOper(message = "保存或修改用户")
	public void saveSysUser(UserFormBean userFormBean) throws Exception {
		userService.saveSysUser(userFormBean);
	}

	/**
	 * 删除用户
	 * 
	 * @author Sun Rising
	 * @date 2019.06.20 09:37:25
	 * @param uuid
	 *
	 */
	@DeleteMapping("/delSysUser/{uuids}")
	@LogOper(message = "删除用户")
	public void delSysUser(@PathVariable("uuids") String[] uuids) {
		if (uuids.length > 0)
			userService.delSysUser(uuids);
	}

	/***
	 * 用户锁定
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:24:31
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@PutMapping("/userLock/{uuids}")
	@LogOper(message = "锁定用户")
	public void userLock(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0)
			userService.userLock(uuids);
	}

	/**
	 * 用户解锁
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:24:45
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@PutMapping("/userUnlock/{uuids}")
	@LogOper(message = "解锁用户")
	public void userUnlock(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0)
			userService.userUnlock(uuids);
	}

	/**
	 * 用户注销
	 * 
	 * @author Sun Rising
	 * @date 2019.07.06 09:24:56
	 * @param uuids
	 * @throws Exception
	 *
	 */
	@PutMapping("/userDest/{uuids}")
	@LogOper(message = "注销用户")
	public void userDest(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0)
			userService.userDest(uuids);
	}

	@PutMapping("/pwdRest/{uuids}")
	@LogOper(message = "用户密码重置")
	public void pwdRest(@PathVariable("uuids") String[] uuids) throws Exception {
		if (uuids.length > 0)
			userService.pwdRest(uuids);
	}
}
