package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 交互日志(LOG_OPER)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "LOG_OPER")
public class LogOper implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -2185681709276130005L;

    /** 主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 请求路径 */
    @Column(name = "REQ_URL", nullable = true, length = 255)
    private String reqUrl;

    /** 路径说明 */
    @Column(name = "URL_DESC", nullable = true, length = 50)
    private String urlDesc;

    /** 服务器地址 */
    @Column(name = "SVR_ADRR", nullable = true, length = 20)
    private String svrAdrr;

    /** 服务器名称 */
    @Column(name = "SVR_NAME", nullable = true, length = 255)
    private String svrName;

    /** 客户端地址 */
    @Column(name = "CLI_ADRR", nullable = true, length = 20)
    private String cliAdrr;

    /** 客户端说明 */
    @Column(name = "CLI_DESC", nullable = true, length = 255)
    private String cliDesc;

    /** 操作开始时间 */
    @Column(name = "START_TIME", nullable = true, length = 24)
    private Long startTime;

    /** 耗时 */
    @Column(name = "PROC_TIME", nullable = true, length = 24)
    private Long procTime;

    /** 服务器响应代码 */
    @Column(name = "RESP_CODE", nullable = true, length = 10)
    private String respCode;

    /** 服务器响应说明 */
    @Column(name = "RESP_DESC", nullable = true, length = 50)
    private String respDesc;

    /** 操作人 */
    @Column(name = "OP_USER", nullable = true, length = 50)
    private String opUser;

    /** 异常信息 */
    @Column(name = "EXEC_INFO", nullable = true, length = 1500)
    private String execInfo;

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
     * 获取请求路径
     * 
     * @return 请求路径
     */
    public String getReqUrl() {
        return this.reqUrl;
    }

    /**
     * 设置请求路径
     * 
     * @param reqUrl
     *          请求路径
     */
    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    /**
     * 获取路径说明
     * 
     * @return 路径说明
     */
    public String getUrlDesc() {
        return this.urlDesc;
    }

    /**
     * 设置路径说明
     * 
     * @param urlDesc
     *          路径说明
     */
    public void setUrlDesc(String urlDesc) {
        this.urlDesc = urlDesc;
    }

    /**
     * 获取服务器地址
     * 
     * @return 服务器地址
     */
    public String getSvrAdrr() {
        return this.svrAdrr;
    }

    /**
     * 设置服务器地址
     * 
     * @param svrAdrr
     *          服务器地址
     */
    public void setSvrAdrr(String svrAdrr) {
        this.svrAdrr = svrAdrr;
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
     * 获取客户端地址
     * 
     * @return 客户端地址
     */
    public String getCliAdrr() {
        return this.cliAdrr;
    }

    /**
     * 设置客户端地址
     * 
     * @param cliAdrr
     *          客户端地址
     */
    public void setCliAdrr(String cliAdrr) {
        this.cliAdrr = cliAdrr;
    }

    /**
     * 获取客户端说明
     * 
     * @return 客户端说明
     */
    public String getCliDesc() {
        return this.cliDesc;
    }

    /**
     * 设置客户端说明
     * 
     * @param cliDesc
     *          客户端说明
     */
    public void setCliDesc(String cliDesc) {
        this.cliDesc = cliDesc;
    }

    /**
     * 获取操作开始时间
     * 
     * @return 操作开始时间
     */
    public Long getStartTime() {
        return this.startTime;
    }

    /**
     * 设置操作开始时间
     * 
     * @param startTime
     *          操作开始时间
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取耗时
     * 
     * @return 耗时
     */
    public Long getProcTime() {
        return this.procTime;
    }

    /**
     * 设置耗时
     * 
     * @param procTime
     *          耗时
     */
    public void setProcTime(Long procTime) {
        this.procTime = procTime;
    }

    /**
     * 获取服务器响应代码
     * 
     * @return 服务器响应代码
     */
    public String getRespCode() {
        return this.respCode;
    }

    /**
     * 设置服务器响应代码
     * 
     * @param respCode
     *          服务器响应代码
     */
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    /**
     * 获取服务器响应说明
     * 
     * @return 服务器响应说明
     */
    public String getRespDesc() {
        return this.respDesc;
    }

    /**
     * 设置服务器响应说明
     * 
     * @param respDesc
     *          服务器响应说明
     */
    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    /**
     * 获取操作人
     * 
     * @return 操作人
     */
    public String getOpUser() {
        return this.opUser;
    }

    /**
     * 设置操作人
     * 
     * @param opUser
     *          操作人
     */
    public void setOpUser(String opUser) {
        this.opUser = opUser;
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
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}