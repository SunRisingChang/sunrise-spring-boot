package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统角色 (SYS_ROLE)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_ROLE")
public class SysRole implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5795666175486998388L;

    /** 表主键 */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 隶属组织 */
    @Column(name = "ORG_UUID", nullable = true, length = 50)
    private String orgUuid;

    /** 角色编码 */
    @Column(name = "ROLE_CODE", nullable = true, length = 50)
    private String roleCode;

    /** 角色名称 */
    @Column(name = "ROLE_NAME", nullable = true, length = 50)
    private String roleName;

    /** 角色描述 */
    @Column(name = "ROLE_DESC", nullable = true, length = 50)
    private String roleDesc;

    /** 角色继承 */
    @Column(name = "ROLE_PARE", nullable = true, length = 50)
    private String rolePare;

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
     * 获取角色编码
     * 
     * @return 角色编码
     */
    public String getRoleCode() {
        return this.roleCode;
    }

    /**
     * 设置角色编码
     * 
     * @param roleCode
     *          角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取角色名称
     * 
     * @return 角色名称
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * 设置角色名称
     * 
     * @param roleName
     *          角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色描述
     * 
     * @return 角色描述
     */
    public String getRoleDesc() {
        return this.roleDesc;
    }

    /**
     * 设置角色描述
     * 
     * @param roleDesc
     *          角色描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * 获取角色继承
     * 
     * @return 角色继承
     */
    public String getRolePare() {
        return this.rolePare;
    }

    /**
     * 设置角色继承
     * 
     * @param rolePare
     *          角色继承
     */
    public void setRolePare(String rolePare) {
        this.rolePare = rolePare;
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