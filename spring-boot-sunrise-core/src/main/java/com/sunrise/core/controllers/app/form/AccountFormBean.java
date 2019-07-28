package com.sunrise.core.controllers.app.form;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.sunrise.core.base.BaseBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 账户表单
 * 
 * @author Sun_Rising
 * @date 2018.12.27 02:14:51
 *
 */
@Getter
@Setter
@ToString
public class AccountFormBean extends BaseBean {

	@NotBlank(message = "userName不能为空!")
	@Length(max = 255, message = "长度不可超过255")
	private String userName;// 用户名

	@NotBlank(message = "passWd不能为空!")
	@Length(max = 255, message = "长度不可超过255")
	private String passWd;// 密码

	private String captcha;// 验证码
}
