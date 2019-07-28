package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * Quartz日志(LOG_QUARTZ)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "LOG_QUARTZ")
public class LogQuartz implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -6356110576419712203L;

    /** 主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 任务名称 */
    @Column(name = "QTZ_NAME", nullable = true, length = 50)
    private String qtzName;

    /** 任务组 */
    @Column(name = "QTZ_GROUP", nullable = true, length = 50)
    private String qtzGroup;

    /** 服务器名称 */
    @Column(name = "SVR_NAME", nullable = true, length = 50)
    private String svrName;

    /** 服务器地址 */
    @Column(name = "SVR_ADDR", nullable = true, length = 50)
    private String svrAddr;

    /** 日记等级 1、系统记录 2、手动记录 */
    @Column(name = "LOG_LEVE", nullable = true, length = 2)
    private String logLeve;

    /** 异常信息 */
    @Column(name = "EXEC_INFO", nullable = true, length = 1500)
    private String execInfo;

    /** 开始执行时间 */
    @Column(name = "START_TIME", nullable = true, length = 24)
    private Long startTime;

    /** 处理耗时 */
    @Column(name = "PROC__TIME", nullable = true, length = 24)
    private Long procTime;

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
    public String getQtzName() {
        return this.qtzName;
    }

    /**
     * 设置任务名称
     * 
     * @param qtzName
     *          任务名称
     */
    public void setQtzName(String qtzName) {
        this.qtzName = qtzName;
    }

    /**
     * 获取任务组
     * 
     * @return 任务组
     */
    public String getQtzGroup() {
        return this.qtzGroup;
    }

    /**
     * 设置任务组
     * 
     * @param qtzGroup
     *          任务组
     */
    public void setQtzGroup(String qtzGroup) {
        this.qtzGroup = qtzGroup;
    }

    /**
     * 获取服务器名称
     * 
     * @return 服务器名称
     */
    public String getSvrName() {
        return this.svrName;
    }

    /**
     * 设置服务器名称
     * 
     * @param svrName
     *          服务器名称
     */
    public void setSvrName(String svrName) {
        this.svrName = svrName;
    }

    /**
     * 获取服务器地址
     * 
     * @return 服务器地址
     */
    public String getSvrAddr() {
        return this.svrAddr;
    }

    /**
     * 设置服务器地址
     * 
     * @param svrAddr
     *          服务器地址
     */
    public void setSvrAddr(String svrAddr) {
        this.svrAddr = svrAddr;
    }

    /**
     * 获取日记等级 1、系统记录 2、手动记录
     * 
     * @return 日记等级 1、系统记录 2、手动记录
     */
    public String getLogLeve() {
        return this.logLeve;
    }

    /**
     * 设置日记等级 1、系统记录 2、手动记录
     * 
     * @param logLeve
     *          日记等级 1、系统记录 2、手动记录
     */
    public void setLogLeve(String logLeve) {
        this.logLeve = logLeve;
    }

    /**
     * 获取异常信息
     * 
     * @return 异常信息
     */
    public String getExecInfo() {
        return this.execInfo;
    }

    /**
     * 设置异常信息
     * 
     * @param execInfo
     *          异常信息
     */
    public void setExecInfo(String execInfo) {
        this.execInfo = execInfo;
    }

    /**
     * 获取开始执行时间
     * 
     * @return 开始执行时间
     */
    public Long getStartTime() {
        return this.startTime;
    }

    /**
     * 设置开始执行时间
     * 
     * @param startTime
     *          开始执行时间
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取处理耗时
     * 
     * @return 处理耗时
     */
    public Long getProcTime() {
        return this.procTime;
    }

    /**
     * 设置处理耗时
     * 
     * @param procTime
     *          处理耗时
     */
    public void setProcTime(Long procTime) {
        this.procTime = procTime;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}