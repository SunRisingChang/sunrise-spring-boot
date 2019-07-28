package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统字典组 (SYS_DICT_GROUP)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_DICT_GROUP")
public class SysDictGroup implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5435892653014317605L;

    /** 主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 字典组名称 */
    @Column(name = "GROUP_NAME", nullable = true, length = 50)
    private String groupName;

    /** 字典组key */
    @Column(name = "GROUP_KEY", nullable = true, length = 50)
    private String groupKey;

    /** 字典类型 代码类型: 1 列表类型 2 树类型 */
    @Column(name = "DICT_TYPE", nullable = true, length = 2)
    private String dictType;

    /** 字典组状态 */
    @Column(name = "GROUP_STAT", nullable = true, length = 2)
    private String groupStat;

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
     * 获取主键
     * 
     * @return 主键
     */
    public String getUuid() {
        return this.uuid;
    }

    /**
     * 设置主键
     * 
     * @param uuid
     *          主键
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取字典组名称
     * 
     * @return 字典组名称
     */
    public String getGroupName() {
        return this.groupName;
    }

    /**
     * 设置字典组名称
     * 
     * @param groupName
     *          字典组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取字典组key
     * 
     * @return 字典组key
     */
    public String getGroupKey() {
        return this.groupKey;
    }

    /**
     * 设置字典组key
     * 
     * @param groupKey
     *          字典组key
     */
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    /**
     * 获取字典类型 代码类型: 1 列表类型 2 树类型
     * 
     * @return 字典类型 代码类型
     */
    public String getDictType() {
        return this.dictType;
    }

    /**
     * 设置字典类型 代码类型: 1 列表类型 2 树类型
     * 
     * @param dictType
     *          字典类型 代码类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    /**
     * 获取字典组状态
     * 
     * @return 字典组状态
     */
    public String getGroupStat() {
        return this.groupStat;
    }

    /**
     * 设置字典组状态
     * 
     * @param groupStat
     *          字典组状态
     */
    public void setGroupStat(String groupStat) {
        this.groupStat = groupStat;
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