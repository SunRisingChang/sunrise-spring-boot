package com.sunrise.core.config.shiro.imp;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import com.sunrise.core.config.ehcache.imp.CacheService;
import com.sunrise.core.config.shiro.entity.UserBean;
import com.sunrise.core.constant.ExceptionConst;
import com.sunrise.core.constant.SystemConst;
import com.sunrise.core.entitys.SysUser;
import com.sunrise.core.services.app.AccountService;
import com.sunrise.core.utils.KeyCreatUtils;
import com.sunrise.core.utils.ThreadLocalUtils;

/**
 * shiro登录令牌校验
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:05:27
 *
 */
public class CustomRealm extends AuthorizingRealm implements CredentialsMatcher {

	@Autowired
	@Lazy
	private AccountService accountService;

	@Autowired
	private CacheService cacheService;

	@Value("${shiro.custom.loginWarnNumber}")
	private int loginWarnNumber;

	@Value("${shiro.custom.loginLockNumber}")
	private int loginLockNumber;
	{
		// 设置Realm名称
		super.setName("CustomRealm");
		// 设置密码检验器
		this.setCredentialsMatcher(this);
	}

	/**
	 * 认证
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:05:52
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 *
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		final String userName = usernamePasswordToken.getUsername();
		// 获取用户实体
		SysUser sysUser = accountService.getSysUserByName(userName);
		if (sysUser == null) {
			throw new UnknownAccountException();
		}
		// 账户注销
		if (SystemConst.ACCOUNT_DEST.equals(sysUser.getAcStat())) {
			throw new DisabledAccountException();
		}
		// 账户锁定
		if (SystemConst.ACCOUNT_LOCK.equals(sysUser.getAcStat())) {
			throw new LockedAccountException();
		}
		/**
		 * SimpleAuthenticationInfo参数说明
		 * 第一个参数：从数据库中获取的用户对象或用户名，可以通过SecurityUtils.getSubject().getPrincipal()获取
		 * 第二个参数：从数据库中获取的用户对象密码 第三个参数[可选]：从数据库中获取的用户对象密码的盐 第四个参数：是哪个Realm处理的 之后将进行密码的验证
		 */
		return new SimpleAuthenticationInfo(sysUser, sysUser.getAcPwd(), super.getName());
	}

	/**
	 * 验证密码
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:06:02
	 * @param token
	 * @param info
	 * @return
	 *
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		// 前台传入的登录信息
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		// 前台传入的密码
		String webPwd = new String(usernamePasswordToken.getPassword());
		// 数据库检出的密码
		String dbPwd = info.getCredentials().toString();
		boolean isOK = webPwd.equals(dbPwd);
		// -------------------- 密码校验 开始 -------------------
		String currUserKey = KeyCreatUtils.getPrefixKeyBySession(usernamePasswordToken.getUsername());
		// 是否开启计数
		boolean isOpenNum = loginWarnNumber != 0 || loginLockNumber != 0;
		if (isOpenNum)
			if (isOK) {
				cacheService.getLocalCache().remove(currUserKey);
			} else {
				Object _loginStat = cacheService.getLocalCache().get(currUserKey);
				int loginStat = _loginStat == null ? 0 : Integer.parseInt(_loginStat.toString());
				cacheService.getLocalCache().put(currUserKey, loginStat + 1);
				String msgString = " , 您还有 " + (loginLockNumber - loginStat) + " 次机会";
				if (loginLockNumber != 0 && loginStat >= loginLockNumber) {
					// 通知账户锁定
					accountService.accountLock(usernamePasswordToken.getUsername());
					cacheService.getLocalCache().remove(currUserKey);
					throw new LockedAccountException();
				}
				if (loginWarnNumber != 0 && loginStat >= loginWarnNumber) {
					throw new ExcessiveAttemptsException(loginLockNumber != 0 ? ExceptionConst.SHIRO_EXCESSIVE_ATTEMPTS.getMessage() + msgString : ExceptionConst.SHIRO_EXCESSIVE_ATTEMPTS.getMessage());
				}
				throw new IncorrectCredentialsException(loginLockNumber != 0 ? ExceptionConst.SHIRO_INCORRECT_CREDENTIALS.getMessage() + msgString : ExceptionConst.SHIRO_INCORRECT_CREDENTIALS.getMessage());
			}
		// -------------------- 密码校验 结束 -------------------
		if (!isOK)
			throw new IncorrectCredentialsException(ExceptionConst.SHIRO_INCORRECT_CREDENTIALS.getMessage());
		return true;
	}

	/**
	 * 授权 会进入授权方法一共有三种情况: 1、subject.hasRole(“admin”)、
	 * subject.isPermitted(“admin”)... 2、@RequiresRoles("admin") ... 在方法上加注解的时候
	 * 3、[@shiro.hasPermission name = "admin"][/@shiro.hasPermission]...
	 * 在页面上加shiro标签的时候
	 * 
	 * @author Sun_Rising
	 * @date 2018.12.27 02:06:11
	 * @param principals
	 * @return
	 *
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取缓存的用户
		UserBean userBean = (UserBean) ThreadLocalUtils.get(KeyCreatUtils.getPrefixKeyBySession(SystemConst.USER_BEAN));
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (userBean != null) {
//			info.addRoles(userBean.getRolesKey());
//			info.addStringPermissions(userBean.getPermsKey());
		}
		return info;
	}
}
