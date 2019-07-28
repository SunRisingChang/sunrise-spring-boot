package com.sunrise.core.config.shiro.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.sunrise.core.entitys.SysPerm;
import com.sunrise.core.entitys.SysRole;
import lombok.Data;

/**
 * shiro用户封装类，用于全局访问
 * 
 * @author Sun Rising
 * @date 2019.05.30 11:39:13
 *
 */
@Data
public class UserBean implements Serializable {

	/**
	 * serialVersionUID type is long
	 * 
	 * @author Sun Rising
	 * @date 2019.06.08 06:09:10
	 **/
	private static final long serialVersionUID = 3995038063346887344L;

	// 用户名
	private String userName;

	// 角色
	private List<SysRole> roles = new ArrayList<SysRole>();

	// 权限
	private List<SysPerm> perms = new ArrayList<SysPerm>();
}
