package com.sunrise.core.controllers.usrm.form;

import java.util.ArrayList;
import java.util.List;
import com.sunrise.core.base.BaseBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户表单
 * 
 * @author Sun Rising
 * @date 2019.06.19 08:38:20
 *
 */
@Getter
@Setter
@ToString
public class UserFormBean extends BaseBean {

	private String uuid;

	/** 账户 */
	private String acName;

	/** 密码 */
	private String acPwd;

	/** 盐 */
	private String encSalt;

	/** 隶属组织 */
	private String orgUuid;

	/** 状态 1、正常 2、锁定 3、注销 */
	private String acStat;

	/** 最后登录时间 */
	private Long lastLogDate;

	/** 用户名 */
	private String userName;

	/** 性别 */
	private String userSex;

	/** 联系电话 */
	private String userPhone;

	/** 邮件 */
	private String userEmail;

	/** 生日 */
	private Long userBirthday;

	/** 角色信息 */
	private List<String> roleUuids = new ArrayList<String>();
}
