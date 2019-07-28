package com.sunrise.core.controllers.sysm.form;

import com.sunrise.core.entitys.SysQuartz;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * quartz表单
 * 
 * @author Sun Rising
 * @date 2019.07.02 11:39:59
 *
 */
@Getter
@Setter
@ToString
public class QuartzFormBean extends SysQuartz {

	/**
	 * serialVersionUID type is long
	 * 
	 * @author Sun Rising
	 * @date 2019.07.02 01:28:45
	 **/
	private static final long serialVersionUID = -2421055624454509524L;

	/** 立即运行 */
	private boolean isRun;
}
