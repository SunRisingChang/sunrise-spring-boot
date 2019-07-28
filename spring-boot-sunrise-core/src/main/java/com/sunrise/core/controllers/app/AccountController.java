package com.sunrise.core.controllers.app;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunrise.core.base.BaseController;
import com.sunrise.core.config.annotations.LogOper;
import com.sunrise.core.controllers.app.form.AccountFormBean;
import com.sunrise.core.entitys.SysUserInfo;
import com.sunrise.core.services.app.AccountService;

/**
 * 账户管理
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:15:52
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {

	@Autowired
	private AccountService accountService;

	/**
	 * 系统登录
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:16:03
	 * @param accountFormBean
	 * @return
	 * @throws Exception
	 *
	 */
	@PostMapping("/anon/login")
	public Object login(@Validated AccountFormBean accountFormBean) throws Exception {
		return accountService.login(accountFormBean);
	}

	/**
	 * 是否已经登录
	 * 
	 * @author Sun Rising
	 * @date 2019.06.25 06:13:22
	 * @return
	 * @throws Exception
	 *
	 */
	@GetMapping("/anon/isLogged")
	public Object isLogged() throws Exception {
		return accountService.isLogged();
	}

	/**
	 * 保存用户信息
	 * 
	 * @author Sun Rising
	 * @date 2019.07.05 04:25:44
	 * @param sysUserInfo
	 * @throws Exception
	 *
	 */
	@PostMapping("/saveUserInfo")
	@LogOper(message = "保存或修改用户信息")
	public void saveUserInfo(@RequestBody SysUserInfo sysUserInfo) throws Exception {
		accountService.saveUserInfo(sysUserInfo);
	}

	/**
	 * 获取图片验证码
	 * 
	 * @author Sun Rising
	 * @date 2019.06.13 07:33:47
	 * @param response
	 *
	 */
	@GetMapping("/anon/getKaptchaImage")
	public void getKaptchaImage(HttpServletResponse response) {
		accountService.getKaptchaImage(response);
	}

	/**
	 * 修改用户密码
	 * 
	 * @author Sun Rising
	 * @date 2019.07.05 05:22:13
	 * @param oldPwd
	 * @param newPwd
	 * @throws Exception
	 *
	 */
	@PostMapping("/changePwd")
	@LogOper(message = "修改用户密码")
	public void changePwd(@RequestBody Map<String, String> jsonMap) throws Exception {
		String oldPwd = jsonMap.get("oldPwd");
		String newPwd = jsonMap.get("newPwd");
		if (StringUtils.isNotBlank(oldPwd) && StringUtils.isNotBlank(newPwd)) {
			accountService.changePwd(oldPwd.toString(), newPwd.toString());
		}
	}

	/**
	 * 系统注销
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:16:17
	 *
	 */
	@GetMapping("/logout")
	public void logout() {
		accountService.logout();
	}

	/**
	 * 获取前端初始化信息
	 * 
	 * @author Sun Rising
	 * @date 2019.06.21 08:12:12
	 * @return
	 *
	 */
	@GetMapping("/initSystem")
	public Object initSystem() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sysMenu", accountService.getAvailableMenu());
		return map;
	}
}
