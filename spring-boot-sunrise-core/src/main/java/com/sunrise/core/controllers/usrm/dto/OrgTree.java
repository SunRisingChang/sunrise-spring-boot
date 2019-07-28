package com.sunrise.core.controllers.usrm.dto;

import java.util.List;
import com.sunrise.core.entitys.SysOrg;
import lombok.Getter;
import lombok.Setter;

/**
 * 组织树
 * 
 * @author Sun Rising
 * @date 2019.06.26 10:39:48
 *
 */
@Getter
@Setter
public class OrgTree extends SysOrg {

	/**
	 * serialVersionUID type is long
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 10:39:23
	 **/
	private static final long serialVersionUID = 4218076432425282366L;

	private List<OrgTree> children;
}
