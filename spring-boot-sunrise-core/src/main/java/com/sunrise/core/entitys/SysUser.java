package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统用户表 (SYS_USER)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_USER")
public class SysUser implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7623599949223066576L;

    /** 表主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 用户名 */
    @Column(name = "AC_NAME", nullable = true, length = 50)
    private String acName;

    /** 密码 */
    @Column(name = "AC_PWD", nullable = true, length = 50)
    private String acPwd;

    /** 状态 1、正常 2、锁定 3、注销 */
    @Column(name = "AC_STAT", nullable = true, length = 2)
    private String acStat;

    /** 盐 */
    @Column(name = "ENC_SALT", nullable = true, length = 50)
    private String encSalt;

    /** 隶属组织 */
    @Column(name = "ORG_UUID", nullable = true, length = 32)
    private String orgUuid;

    /** 最后登录时间 */
    @Column(name = "LAST_LOG_DATE", nullable = true, length = 24)
    private Long lastLogDate;

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
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getAcName() {
        return this.acName;
    }

    /**
     * 设置用户名
     * 
     * @param acName
     *          用户名
     */
    public void setAcName(String acName) {
        this.acName = acName;
    }

    /**
     * 获取密码
     * 
     * @return 密码
     */
    public String getAcPwd() {
        return this.acPwd;
    }

    /**
     * 设置密码
     * 
     * @param acPwd
     *          密码
     */
    public void setAcPwd(String acPwd) {
        this.acPwd = acPwd;
    }

    /**
     * 获取状态 1、正常 2、锁定 3、注销
     * 
     * @return 状态 1、正常 2、锁定 3、注销
     */
    public String getAcStat() {
        return this.acStat;
    }

    /**
     * 设置状态 1、正常 2、锁定 3、注销
     * 
     * @param acStat
     *          状态 1、正常 2、锁定 3、注销
     */
    public void setAcStat(String acStat) {
        this.acStat = acStat;
    }

    /**
     * 获取盐
     * 
     * @return 盐
     */
    public String getEncSalt() {
        return this.encSalt;
    }

    /**
     * 设置盐
     * 
     * @param encSalt
     *          盐
     */
    public void setEncSalt(String encSalt) {
        this.encSalt = encSalt;
    }

    /**
     * 获取隶属组织
     * 
     * @return 隶属组织
     */
    public String getOrgUuid() {
        return this.orgUuid;
    }

    /**
     * 设置隶属组织
     * 
     * @param orgUuid
     *          隶属组织
     */
    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    /**
     * 获取最后登录时间
     * 
     * @return 最后登录时间
     */
    public Long getLastLogDate() {
        return this.lastLogDate;
    }

    /**
     * 设置最后登录时间
     * 
     * @param lastLogDate
     *          最后登录时间
     */
    public void setLastLogDate(Long lastLogDate) {
        this.lastLogDate = lastLogDate;
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