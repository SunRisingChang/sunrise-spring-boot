package com.sunrise.core.services.app;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.sunrise.core.base.BaseService;
import com.sunrise.core.config.exception.CustomRuntimeException;
import com.sunrise.core.constant.ExceptionConst;
import com.sunrise.core.constant.SystemConst;
import com.sunrise.core.controllers.app.form.AccountFormBean;
import com.sunrise.core.daos.app.AccountDao;
import com.sunrise.core.daos.sysm.MenuDao;
import com.sunrise.core.daos.usrm.UserDao;
import com.sunrise.core.entitys.SysMenu;
import com.sunrise.core.entitys.SysPerm;
import com.sunrise.core.entitys.SysRole;
import com.sunrise.core.entitys.SysRolePerm;
import com.sunrise.core.entitys.SysUser;
import com.sunrise.core.entitys.SysUserInfo;
import com.sunrise.core.entitys.SysUserRole;
import com.sunrise.core.utils.EncodeUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 账户管理
 * 
 * @author Sun Rising
 * @date 2020.05.01 11:34:48
 *
 */
@Slf4j
@Service
public class AccountService extends BaseService {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private DefaultKaptcha kaptchaProducer;

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private UserDao userDao;

	/**
	 * 通过用户名获取用户对象
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:19:41
	 * @param userName
	 * @return
	 *
	 */
	public SysUser getSysUserByName(String userName) {
		return userDao.getSysUserByName(userName);
	}

	/**
	 * 系统登录
	 * 
	 * @author Sun Rising
	 * @date 2020.05.01 11:35:01
	 * @param accountFormBean
	 * @return
	 * @throws Exception
	 *
	 */
	public Object login(AccountFormBean accountFormBean) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(accountFormBean.getUserName(), accountFormBean.getPassWd());
		subject.login(usernamePasswordToken);
		SysUser sysUser = (SysUser) subject.getPrincipal();
		Map<String, String> sysUserMap = BeanUtils.describe(sysUser);
		SysUserInfo sysUserInfo = userDao.getSysUserInfoByUserUuid(sysUser.getUuid());
		Map<String, String> sysUserInfoMap = BeanUtils.describe(sysUserInfo);
		sysUserMap.putAll(sysUserInfoMap);
		return sysUserMap;
	}

	/**
	 * 判断是否登录
	 * 
	 * @author Sun Rising
	 * @date 2019.07.05 03:44:02
	 * @return
	 * @throws Exception
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 *
	 */
	public Object isLogged() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		Map<String, String> _sysUserInfo = new HashMap<String, String>();
		if (subject.isAuthenticated()) {
			SysUser sysUser = (SysUser) subject.getPrincipal();
			Map<String, String> sysUserMap = BeanUtils.describe(sysUser);
			SysUserInfo sysUserInfo = userDao.getSysUserInfoByUserUuid(sysUser.getUuid());
			Map<String, String> sysUserInfoMap = BeanUtils.describe(sysUserInfo);
			_sysUserInfo.putAll(sysUserMap);
			_sysUserInfo.putAll(sysUserInfoMap);
		} else {
			throw new CustomRuntimeException(ExceptionConst.SHIRO_CREDENTITALS.getCode(), ExceptionConst.SHIRO_CREDENTITALS.getMessage());
		}
		return _sysUserInfo;
	}

	/**
	 * 系统注销
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:20:38
	 *
	 */
	public void logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
	}

	/**
	 * 通过用户名获取用户角色
	 * 
	 * @author Sun Rising
	 * @date 2019.05.30 12:15:04
	 * @param userId
	 * @return
	 *
	 */
	public List<SysRole> getSysRoleById(String userId) {
		List<SysRole> sysRoles = new ArrayList<SysRole>();
		if (StringUtils.isNotBlank(userId)) {
			// 获取用户和角色的关联
			List<SysUserRole> sysUserRoles = accountDao.getSysUserRoleByUserId(userId);
			for (SysUserRole sysUserRole : sysUserRoles) {
				// 查找角色
				SysRole sysRole = accountDao.getEntityManager().find(SysRole.class, sysUserRole.getRoleUuid());
				// 装配角色
				sysRoles.add(sysRole);
			}
		}
		return sysRoles;
	}

	/**
	 * 通过用户名获取用户权限
	 * 
	 * @author Sun Rising
	 * @date 2019.05.30 12:17:05
	 * @param roles
	 * @return
	 *
	 */
	public List<SysPerm> getSysPermByRoles(List<SysRole> roles) {
		List<SysPerm> sysPerms = new ArrayList<SysPerm>();
		for (SysRole sysRole : roles) {
			// 查询角色和权限的关联
			List<SysRolePerm> sysRolePerms = accountDao.getSysRolePermByRoleId(sysRole.getUuid());
			for (SysRolePerm sysRolePerm : sysRolePerms) {
				// 查找权限
				SysPerm sysPerm = accountDao.getEntityManager().find(SysPerm.class, sysRolePerm.getPermUuid());
				// 装配权限
				sysPerms.add(sysPerm);
			}
		}
		return sysPerms;
	}

	/**
	 * 获取图片验证码
	 * 
	 * @author Sun Rising
	 * @date 2019.06.13 07:34:19
	 * @param response
	 *
	 */
	public void getKaptchaImage(HttpServletResponse response) {
		try (ServletOutputStream out = response.getOutputStream()) {
			response.setDateHeader("Expires", 0);
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			response.addHeader("Cache-Control", "post-check=0, pre-check=0");
			response.setHeader("Pragma", "no-cache");
			response.setContentType("image/jpeg");
			String capText = kaptchaProducer.createText();
			// 生成的验证码存入session
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute(SystemConst.KAPTCHA_CODE, capText);
			BufferedImage bImage = kaptchaProducer.createImage(capText);
			ImageIO.write(bImage, "jpg", out);
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException("验证码生成失败 ！");
		}
	}

	/**
	 * 锁定用户
	 * 
	 * @author Sun Rising
	 * @date 2019.06.18 07:34:39
	 * @param userName
	 *
	 */
	@Transactional
	public void accountLock(String userName) {
		SysUser sysUser = userDao.getSysUserByName(userName);
		if (sysUser != null) {
			sysUser.setAcStat(SystemConst.ACCOUNT_LOCK);
			accountDao.getEntityManager().merge(sysUser);
		}
	}

	/**
	 * 获取当前用户可用的菜单
	 * 
	 * @author Sun Rising
	 * @date 2019.06.30 09:31:07
	 * @return
	 *
	 */
	public List<SysMenu> getAvailableMenu() {
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		if (SystemConst.ADMIN_ACCOUNT.equals(sysUser.getAcName())) {
			return menuDao.getSysMenu();
		}
		return accountDao.getAvailableMenu(sysUser.getUuid());
	}

	/**
	 * 保存用户信息
	 * 
	 * @author Sun Rising
	 * @date 2019.07.05 04:26:40
	 * @param sysUserInfo
	 * @throws Exception
	 *
	 */
	@Transactional
	public void saveUserInfo(SysUserInfo sysUserInfo) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser) subject.getPrincipal();
		sysUserInfo.setUserUuid(sysUser.getUuid());
		SysUserInfo _sysUserInfo = userDao.getSysUserInfoByUserUuid(sysUser.getUuid());
		if (_sysUserInfo == null) {
			sysUserInfo.setUuid(null);
			accountDao.persistAutoWriteMsg(sysUserInfo);
		} else {
			sysUserInfo.setUuid(_sysUserInfo.getUuid());
			accountDao.mergeAutoWriteMsg(sysUserInfo);
		}
	}

	/**
	 * 修改用户密码
	 * 
	 * @author Sun Rising
	 * @date 2019.07.05 05:41:36
	 * @param oldPwd
	 * @param newPwd
	 * @throws Exception
	 *
	 */
	@Transactional
	public void changePwd(String oldPwd, String newPwd) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser) subject.getPrincipal();
		String _oldPwd = EncodeUtils.MD5(oldPwd + sysUser.getEncSalt() + sysUser.getUuid());
		if (!_oldPwd.equals(sysUser.getAcPwd())) {
			throw new CustomRuntimeException(ExceptionConst.SHIRO_INCORRECT_CREDENTIALS.getCode(), ExceptionConst.SHIRO_INCORRECT_CREDENTIALS.getMessage());
		}
		SysUser _sysUser = accountDao.getEntityManager().find(SysUser.class, sysUser.getUuid());
		_sysUser.setAcPwd(EncodeUtils.MD5(newPwd + sysUser.getEncSalt() + sysUser.getUuid()));
		accountDao.mergeAutoWriteMsg(_sysUser);
	}

	/**
	 * 更新用户最后登录时间
	 * 
	 * @author Sun Rising
	 * @date 2020.04.26 11:57:58
	 * @param userName
	 *
	 */
	@Transactional
	public void updateLastLoginTime(String userName) {
		try {
			SysUser sysUser = getSysUserByName(userName);
			sysUser.setLastLogDate(System.currentTimeMillis());
			accountDao.getEntityManager().merge(sysUser);
		} catch (Exception e) {
			log.error("用户最后登录时间更新失败。");
		}
	}
}
