package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统字典值 (SYS_DICT_ITEM)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_DICT_ITEM")
public class SysDictItem implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 3117021287679695340L;

    /** 表主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 字典组UUID */
    @Column(name = "GROUP_UUID", nullable = true, length = 32)
    private String groupUuid;

    /** 字典名称 */
    @Column(name = "DICT_NAME", nullable = true, length = 50)
    private String dictName;

    /** 字典key */
    @Column(name = "DICT_KEY", nullable = true, length = 50)
    private String dictKey;

    /** 字典value */
    @Column(name = "DICT_VALUE", nullable = true, length = 50)
    private String dictValue;

    /** 字典排序 */
    @Column(name = "DICT_ORDE", nullable = true, length = 10)
    private Integer dictOrde;

    /** 父字典 适用于树 */
    @Column(name = "DICT_PUUID", nullable = true, length = 32)
    private String dictPuuid;

    /** 字典状态 */
    @Column(name = "DICT_STAT", nullable = true, length = 2)
    private String dictStat;

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
     * 获取字典组UUID
     * 
     * @return 字典组UUID
     */
    public String getGroupUuid() {
        return this.groupUuid;
    }

    /**
     * 设置字典组UUID
     * 
     * @param groupUuid
     *          字典组UUID
     */
    public void setGroupUuid(String groupUuid) {
        this.groupUuid = groupUuid;
    }

    /**
     * 获取字典名称
     * 
     * @return 字典名称
     */
    public String getDictName() {
        return this.dictName;
    }

    /**
     * 设置字典名称
     * 
     * @param dictName
     *          字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取字典key
     * 
     * @return 字典key
     */
    public String getDictKey() {
        return this.dictKey;
    }

    /**
     * 设置字典key
     * 
     * @param dictKey
     *          字典key
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    /**
     * 获取字典value
     * 
     * @return 字典value
     */
    public String getDictValue() {
        return this.dictValue;
    }

    /**
     * 设置字典value
     * 
     * @param dictValue
     *          字典value
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 获取字典排序
     * 
     * @return 字典排序
     */
    public Integer getDictOrde() {
        return this.dictOrde;
    }

    /**
     * 设置字典排序
     * 
     * @param dictOrde
     *          字典排序
     */
    public void setDictOrde(Integer dictOrde) {
        this.dictOrde = dictOrde;
    }

    /**
     * 获取父字典 适用于树
     * 
     * @return 父字典 适用于树
     */
    public String getDictPuuid() {
        return this.dictPuuid;
    }

    /**
     * 设置父字典 适用于树
     * 
     * @param dictPuuid
     *          父字典 适用于树
     */
    public void setDictPuuid(String dictPuuid) {
        this.dictPuuid = dictPuuid;
    }

    /**
     * 获取字典状态
     * 
     * @return 字典状态
     */
    public String getDictStat() {
        return this.dictStat;
    }

    /**
     * 设置字典状态
     * 
     * @param dictStat
     *          字典状态
     */
    public void setDictStat(String dictStat) {
        this.dictStat = dictStat;
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