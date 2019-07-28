package com.sunrise.core.controllers.usrm.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sunrise.core.config.resolver.iface.PostEntity;
import com.sunrise.core.entitys.SysRole;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色编辑表单
 * 
 * @author Sun Rising
 * @date 2019.06.27 09:16:57
 *
 */
@Getter
@Setter
public class RoleFormBean extends SysRole implements PostEntity {

	/**
	 * serialVersionUID type is long
	 * 
	 * @author Sun Rising
	 * @date 2019.06.27 09:12:36
	 **/
	private static final long serialVersionUID = -7320944742058581347L;

	// 权限UUID集合
	Map<String, List<String>> permUuids = new HashMap<String, List<String>>();
}
