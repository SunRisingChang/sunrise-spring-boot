package com.sunrise.core.base;

import com.sunrise.core.config.resolver.iface.PostEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * formBean共有字段
 * 
 * @author Sun Rising
 * @date 2019.06.19 08:48:31
 *
 */
@Getter
@Setter
public class BaseBean implements PostEntity {

	/** 创建人 */
	private String createdUser;

	/** 创建时间 */
	private Long createdTime;

	/** 更新人 */
	private String updatedUser;

	/** 更新时间 */
	private Long updatedTime;
}
