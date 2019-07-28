/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:5.8.8
 */

package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统文件(SYS_FILE)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-09
 */
@Entity
@Table(name = "SYS_FILE")
public class SysFile implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -6886984065902443682L;

    /** 表主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 文件名称 */
    @Column(name = "FILE_NAME", nullable = true, length = 255)
    private String fileName;

    /** 文件MD5 */
    @Column(name = "FILE_MD5", nullable = true, length = 255)
    private String fileMd5;

    /** 服务器存放地址 */
    @Column(name = "FILE_PATH", nullable = true, length = 255)
    private String filePath;

    /** 外网访问地址 */
    @Column(name = "FILE_URL", nullable = true, length = 255)
    private String fileUrl;

    /** 文件类型 */
    @Column(name = "FILE_TYPE", nullable = false, length = 50)
    private String fileType;

    /** 文件大小 */
    @Column(name = "FILE_SIZE", nullable = true, length = 8)
    private Long fileSize;

    /** 文件状态：1、公用 2、私有 */
    @Column(name = "FILE_STAT", nullable = true, length = 2)
    private String fileStat;

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
     * 获取文件名称
     * 
     * @return 文件名称
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * 设置文件名称
     * 
     * @param fileName
     *          文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取文件MD5
     * 
     * @return 文件MD5
     */
    public String getFileMd5() {
        return this.fileMd5;
    }

    /**
     * 设置文件MD5
     * 
     * @param fileMd5
     *          文件MD5
     */
    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    /**
     * 获取服务器存放地址
     * 
     * @return 服务器存放地址
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * 设置服务器存放地址
     * 
     * @param filePath
     *          服务器存放地址
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 获取外网访问地址
     * 
     * @return 外网访问地址
     */
    public String getFileUrl() {
        return this.fileUrl;
    }

    /**
     * 设置外网访问地址
     * 
     * @param fileUrl
     *          外网访问地址
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取文件类型
     * 
     * @return 文件类型
     */
    public String getFileType() {
        return this.fileType;
    }

    /**
     * 设置文件类型
     * 
     * @param fileType
     *          文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取文件大小
     * 
     * @return 文件大小
     */
    public Long getFileSize() {
        return this.fileSize;
    }

    /**
     * 设置文件大小
     * 
     * @param fileSize
     *          文件大小
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取文件状态：1、公用 2、私有
     * 
     * @return 文件状态
     */
    public String getFileStat() {
        return this.fileStat;
    }

    /**
     * 设置文件状态：1、公用 2、私有
     * 
     * @param fileStat
     *          文件状态
     */
    public void setFileStat(String fileStat) {
        this.fileStat = fileStat;
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