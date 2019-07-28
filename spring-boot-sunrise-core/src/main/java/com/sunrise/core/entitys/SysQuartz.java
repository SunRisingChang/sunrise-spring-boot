package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统任务(SYS_QUARTZ)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_QUARTZ")
public class SysQuartz implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1889526526199594878L;

    /** 主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 任务名称 */
    @Column(name = "QUARTZ_NAME", nullable = false, length = 200)
    private String quartzName;

    /** 任务组 */
    @Column(name = "QUARTZ_GROUP", nullable = false, length = 200)
    private String quartzGroup;

    /** 执行状态 */
    @Column(name = "QUARTZ_STAT", nullable = true, length = 16)
    private String quartzStat;

    /** 执行类路径 */
    @Column(name = "QUARTZ_CLASS", nullable = true, length = 250)
    private String quartzClass;

    /** cron表达式 */
    @Column(name = "QUARTZ_CRON", nullable = true, length = 120)
    private String quartzCron;

    /** 优先级 */
    @Column(name = "QUARTZ_PRIORITY", nullable = true, length = 10)
    private Integer quartzPriority;

    /** 初始参数 */
    @Column(name = "QUARTZ_PARAMS", nullable = true, length = 255)
    private String quartzParams;

    /** 执行规则 */
    @Column(name = "QUARTZ_MISFIRE", nullable = true, length = 10)
    private String quartzMisfire;

    /** 任务异常 */
    @Column(name = "QUARTZ_EXCE", nullable = true, length = 1500)
    private String quartzExce;

    /** 任务说明 */
    @Column(name = "QUARTZ_DESC", nullable = true, length = 255)
    private String quartzDesc;

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
     * 获取任务名称
     * 
     * @return 任务名称
     */
    public String getQuartzName() {
        return this.quartzName;
    }

    /**
     * 设置任务名称
     * 
     * @param quartzName
     *          任务名称
     */
    public void setQuartzName(String quartzName) {
        this.quartzName = quartzName;
    }

    /**
     * 获取任务组
     * 
     * @return 任务组
     */
    public String getQuartzGroup() {
        return this.quartzGroup;
    }

    /**
     * 设置任务组
     * 
     * @param quartzGroup
     *          任务组
     */
    public void setQuartzGroup(String quartzGroup) {
        this.quartzGroup = quartzGroup;
    }

    /**
     * 获取执行状态
     * 
     * @return 执行状态
     */
    public String getQuartzStat() {
        return this.quartzStat;
    }

    /**
     * 设置执行状态
     * 
     * @param quartzStat
     *          执行状态
     */
    public void setQuartzStat(String quartzStat) {
        this.quartzStat = quartzStat;
    }

    /**
     * 获取执行类路径
     * 
     * @return 执行类路径
     */
    public String getQuartzClass() {
        return this.quartzClass;
    }

    /**
     * 设置执行类路径
     * 
     * @param quartzClass
     *          执行类路径
     */
    public void setQuartzClass(String quartzClass) {
        this.quartzClass = quartzClass;
    }

    /**
     * 获取cron表达式
     * 
     * @return cron表达式
     */
    public String getQuartzCron() {
        return this.quartzCron;
    }

    /**
     * 设置cron表达式
     * 
     * @param quartzCron
     *          cron表达式
     */
    public void setQuartzCron(String quartzCron) {
        this.quartzCron = quartzCron;
    }

    /**
     * 获取优先级
     * 
     * @return 优先级
     */
    public Integer getQuartzPriority() {
        return this.quartzPriority;
    }

    /**
     * 设置优先级
     * 
     * @param quartzPriority
     *          优先级
     */
    public void setQuartzPriority(Integer quartzPriority) {
        this.quartzPriority = quartzPriority;
    }

    /**
     * 获取初始参数
     * 
     * @return 初始参数
     */
    public String getQuartzParams() {
        return this.quartzParams;
    }

    /**
     * 设置初始参数
     * 
     * @param quartzParams
     *          初始参数
     */
    public void setQuartzParams(String quartzParams) {
        this.quartzParams = quartzParams;
    }

    /**
     * 获取执行规则
     * 
     * @return 执行规则
     */
    public String getQuartzMisfire() {
        return this.quartzMisfire;
    }

    /**
     * 设置执行规则
     * 
     * @param quartzMisfire
     *          执行规则
     */
    public void setQuartzMisfire(String quartzMisfire) {
        this.quartzMisfire = quartzMisfire;
    }

    /**
     * 获取任务异常
     * 
     * @return 任务异常
     */
    public String getQuartzExce() {
        return this.quartzExce;
    }

    /**
     * 设置任务异常
     * 
     * @param quartzExce
     *          任务异常
     */
    public void setQuartzExce(String quartzExce) {
        this.quartzExce = quartzExce;
    }

    /**
     * 获取任务说明
     * 
     * @return 任务说明
     */
    public String getQuartzDesc() {
        return this.quartzDesc;
    }

    /**
     * 设置任务说明
     * 
     * @param quartzDesc
     *          任务说明
     */
    public void setQuartzDesc(String quartzDesc) {
        this.quartzDesc = quartzDesc;
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