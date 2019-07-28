package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 组织管理 (SYS_ORG)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_ORG")
public class SysOrg implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -910570928705418777L;

    /** 表主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 唯一编号 */
    @Column(name = "ORG_CODE", nullable = true, length = 50)
    private String orgCode;

    /** 父组织 */
    @Column(name = "ORG_PARE", nullable = true, length = 50)
    private String orgPare;

    /** 组织名称 */
    @Column(name = "ORG_NAME", nullable = true, length = 50)
    private String orgName;

    /** 组织简称 */
    @Column(name = "ORG_BRF_NAME", nullable = true, length = 50)
    private String orgBrfName;

    /** 组织描述 */
    @Column(name = "ORG_DESC", nullable = true, length = 512)
    private String orgDesc;

    /** 组织负责人 */
    @Column(name = "ORG_MAST", nullable = true, length = 50)
    private String orgMast;

    /** 组织地址 */
    @Column(name = "ORG_ADDR", nullable = true, length = 50)
    private String orgAddr;

    /** 组织邮编 */
    @Column(name = "ORG_POST", nullable = true, length = 50)
    private String orgPost;

    /** 组织电话 */
    @Column(name = "ORG_PHONE", nullable = true, length = 50)
    private String orgPhone;

    /** 组织状态 1、正常 2、禁用 3、注销 */
    @Column(name = "ORG_STAT", nullable = true, length = 2)
    private String orgStat;

    /** 组织排序 */
    @Column(name = "ORG_ORDE", nullable = true, length = 10)
    private Integer orgOrde;

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
     * 获取唯一编号
     * 
     * @return 唯一编号
     */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
     * 设置唯一编号
     * 
     * @param orgCode
     *          唯一编号
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * 获取父组织
     * 
     * @return 父组织
     */
    public String getOrgPare() {
        return this.orgPare;
    }

    /**
     * 设置父组织
     * 
     * @param orgPare
     *          父组织
     */
    public void setOrgPare(String orgPare) {
        this.orgPare = orgPare;
    }

    /**
     * 获取组织名称
     * 
     * @return 组织名称
     */
    public String getOrgName() {
        return this.orgName;
    }

    /**
     * 设置组织名称
     * 
     * @param orgName
     *          组织名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取组织简称
     * 
     * @return 组织简称
     */
    public String getOrgBrfName() {
        return this.orgBrfName;
    }

    /**
     * 设置组织简称
     * 
     * @param orgBrfName
     *          组织简称
     */
    public void setOrgBrfName(String orgBrfName) {
        this.orgBrfName = orgBrfName;
    }

    /**
     * 获取组织描述
     * 
     * @return 组织描述
     */
    public String getOrgDesc() {
        return this.orgDesc;
    }

    /**
     * 设置组织描述
     * 
     * @param orgDesc
     *          组织描述
     */
    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    /**
     * 获取组织负责人
     * 
     * @return 组织负责人
     */
    public String getOrgMast() {
        return this.orgMast;
    }

    /**
     * 设置组织负责人
     * 
     * @param orgMast
     *          组织负责人
     */
    public void setOrgMast(String orgMast) {
        this.orgMast = orgMast;
    }

    /**
     * 获取组织地址
     * 
     * @return 组织地址
     */
    public String getOrgAddr() {
        return this.orgAddr;
    }

    /**
     * 设置组织地址
     * 
     * @param orgAddr
     *          组织地址
     */
    public void setOrgAddr(String orgAddr) {
        this.orgAddr = orgAddr;
    }

    /**
     * 获取组织邮编
     * 
     * @return 组织邮编
     */
    public String getOrgPost() {
        return this.orgPost;
    }

    /**
     * 设置组织邮编
     * 
     * @param orgPost
     *          组织邮编
     */
    public void setOrgPost(String orgPost) {
        this.orgPost = orgPost;
    }

    /**
     * 获取组织电话
     * 
     * @return 组织电话
     */
    public String getOrgPhone() {
        return this.orgPhone;
    }

    /**
     * 设置组织电话
     * 
     * @param orgPhone
     *          组织电话
     */
    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    /**
     * 获取组织状态 1、正常 2、禁用 3、注销
     * 
     * @return 组织状态 1、正常 2、禁用 3、注销
     */
    public String getOrgStat() {
        return this.orgStat;
    }

    /**
     * 设置组织状态 1、正常 2、禁用 3、注销
     * 
     * @param orgStat
     *          组织状态 1、正常 2、禁用 3、注销
     */
    public void setOrgStat(String orgStat) {
        this.orgStat = orgStat;
    }

    /**
     * 获取组织排序
     * 
     * @return 组织排序
     */
    public Integer getOrgOrde() {
        return this.orgOrde;
    }

    /**
     * 设置组织排序
     * 
     * @param orgOrde
     *          组织排序
     */
    public void setOrgOrde(Integer orgOrde) {
        this.orgOrde = orgOrde;
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