package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 角色-权限关联表 (SYS_ROLE_PERM)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_ROLE_PERM")
public class SysRolePerm implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -4250323521286901221L;

    /** 表主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 角色主键 */
    @Column(name = "ROLE_UUID", nullable = false, length = 32)
    private String roleUuid;

    /** 权限主键 */
    @Column(name = "PERM_UUID", nullable = false, length = 32)
    private String permUuid;

    /** 权限资源主键 */
    @Column(name = "RESO_UUID", nullable = true, length = 32)
    private String resoUuid;

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
     * 获取角色主键
     * 
     * @return 角色主键
     */
    public String getRoleUuid() {
        return this.roleUuid;
    }

    /**
     * 设置角色主键
     * 
     * @param roleUuid
     *          角色主键
     */
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    /**
     * 获取权限主键
     * 
     * @return 权限主键
     */
    public String getPermUuid() {
        return this.permUuid;
    }

    /**
     * 设置权限主键
     * 
     * @param permUuid
     *          权限主键
     */
    public void setPermUuid(String permUuid) {
        this.permUuid = permUuid;
    }

    /**
     * 获取权限资源主键
     * 
     * @return 权限资源主键
     */
    public String getResoUuid() {
        return this.resoUuid;
    }

    /**
     * 设置权限资源主键
     * 
     * @param resoUuid
     *          权限资源主键
     */
    public void setResoUuid(String resoUuid) {
        this.resoUuid = resoUuid;
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