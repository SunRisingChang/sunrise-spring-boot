package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统用户信息 (SYS_USER_INFO)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_USER_INFO")
public class SysUserInfo implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5027491548299659686L;

    /** 表主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 用户的uuid */
    @Column(name = "USER_UUID", nullable = true, length = 32)
    private String userUuid;

    /** userName */
    @Column(name = "USER_NAME", nullable = true, length = 50)
    private String userName;

    /** 性别 */
    @Column(name = "USER_SEX", nullable = true, length = 3)
    private String userSex;

    /** 联系电话 */
    @Column(name = "USER_PHONE", nullable = true, length = 32)
    private String userPhone;

    /** 邮件 */
    @Column(name = "USER_EMAIL", nullable = true, length = 32)
    private String userEmail;

    /** 出生年月日 */
    @Column(name = "USER_BIRTHDAY", nullable = true, length = 32)
    private Long userBirthday;

    /** 创建人 */
    @Column(name = "CREATED_USER", nullable = true, length = 32)
    private String createdUser;

    /** 创建时间 */
    @Column(name = "CREATED_TIME", nullable = true, length = 24)
    private Long createdTime;

    /** 更新人 */
    @Column(name = "UPDATED_USER", nullable = true, length = 32)
    private String updatedUser;

    /** 更新时间 */
    @Column(name = "UPDATED_TIME", nullable = true, length = 24)
    private Long updatedTime;

    /**
     * 获取表主键
     * 
     * @return 表主键
     */
    public String getUuid() {
        return this.uuid;
    }

    /**
     * 设置表主键
     * 
     * @param uuid
     *          表主键
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取用户的uuid
     * 
     * @return 用户的uuid
     */
    public String getUserUuid() {
        return this.userUuid;
    }

    /**
     * 设置用户的uuid
     * 
     * @param userUuid
     *          用户的uuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * 获取userName
     * 
     * @return userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置userName
     * 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取性别
     * 
     * @return 性别
     */
    public String getUserSex() {
        return this.userSex;
    }

    /**
     * 设置性别
     * 
     * @param userSex
     *          性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取联系电话
     * 
     * @return 联系电话
     */
    public String getUserPhone() {
        return this.userPhone;
    }

    /**
     * 设置联系电话
     * 
     * @param userPhone
     *          联系电话
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取邮件
     * 
     * @return 邮件
     */
    public String getUserEmail() {
        return this.userEmail;
    }

    /**
     * 设置邮件
     * 
     * @param userEmail
     *          邮件
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取出生年月日
     * 
     * @return 出生年月日
     */
    public Long getUserBirthday() {
        return this.userBirthday;
    }

    /**
     * 设置出生年月日
     * 
     * @param userBirthday
     *          出生年月日
     */
    public void setUserBirthday(Long userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 获取创建人
     * 
     * @return 创建人
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * 设置创建人
     * 
     * @param createdUser
     *          创建人
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Long getCreatedTime() {
        return this.createdTime;
    }

    /**
     * 设置创建时间
     * 
     * @param createdTime
     *          创建时间
     */
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新人
     * 
     * @return 更新人
     */
    public String getUpdatedUser() {
        return this.updatedUser;
    }

    /**
     * 设置更新人
     * 
     * @param updatedUser
     *          更新人
     */
    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    /**
     * 获取更新时间
     * 
     * @return 更新时间
     */
    public Long getUpdatedTime() {
        return this.updatedTime;
    }

    /**
     * 设置更新时间
     * 
     * @param updatedTime
     *          更新时间
     */
    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}