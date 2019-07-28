package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统权限 (SYS_PERM)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_PERM")
public class SysPerm implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7278956337916041744L;

    /** 表主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 资源类型 */
    @Column(name = "PERM_TYPE", nullable = true, length = 50)
    private String permType;

    /** 权限资源隶属表 */
    @Column(name = "PERM_TABLE", nullable = true, length = 50)
    private String permTable;

    /** 权限状态 1、正常 2、禁用 */
    @Column(name = "PERM_STAT", nullable = true, length = 2)
    private String permStat;

    /** 权限描述 */
    @Column(name = "PERM_DESC", nullable = true, length = 50)
    private String permDesc;

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
     * 获取资源类型
     * 
     * @return 资源类型
     */
    public String getPermType() {
        return this.permType;
    }

    /**
     * 设置资源类型
     * 
     * @param permType
     *          资源类型
     */
    public void setPermType(String permType) {
        this.permType = permType;
    }

    /**
     * 获取权限资源隶属表
     * 
     * @return 权限资源隶属表
     */
    public String getPermTable() {
        return this.permTable;
    }

    /**
     * 设置权限资源隶属表
     * 
     * @param permTable
     *          权限资源隶属表
     */
    public void setPermTable(String permTable) {
        this.permTable = permTable;
    }

    /**
     * 获取权限状态 1、正常 2、禁用
     * 
     * @return 权限状态 1、正常 2、禁用
     */
    public String getPermStat() {
        return this.permStat;
    }

    /**
     * 设置权限状态 1、正常 2、禁用
     * 
     * @param permStat
     *          权限状态 1、正常 2、禁用
     */
    public void setPermStat(String permStat) {
        this.permStat = permStat;
    }

    /**
     * 获取权限描述
     * 
     * @return 权限描述
     */
    public String getPermDesc() {
        return this.permDesc;
    }

    /**
     * 设置权限描述
     * 
     * @param permDesc
     *          权限描述
     */
    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
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