package com.sunrise.core.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统菜单 (SYS_MENU)
 * 
 * @author Sun Rising
 * @version 1.0.0 2019-07-03
 */
@Entity
@Table(name = "SYS_MENU")
public class SysMenu implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 4409389272839818854L;

    /** UUID */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "UUID", unique = true, nullable = false, length = 32)
    private String uuid;

    /** 权限标识 */
    @Column(name = "MENU_KEY", nullable = true, length = 50)
    private String menuKey;

    /** 权限名称 */
    @Column(name = "MENU_NAME", nullable = true, length = 50)
    private String menuName;

    /** 父级权限 */
    @Column(name = "MENU_PARENT", nullable = true, length = 32)
    private String menuParent;

    /** 顺序序号 */
    @Column(name = "MENU_ORDE", nullable = true, length = 10)
    private Integer menuOrde;

    /** 权限类型 1：菜单组  2：菜单  3：按钮 */
    @Column(name = "MENU_TYPE", nullable = true, length = 2)
    private String menuType;

    /** 图标 */
    @Column(name = "MENU_ICON", nullable = true, length = 50)
    private String menuIcon;

    /** 菜单地址 */
    @Column(name = "MENU_URL", nullable = true, length = 50)
    private String menuUrl;

    /** 是否可见 */
    @Column(name = "MENU_VISIBLE", nullable = true, length = 2)
    private String menuVisible;

    /** 菜单打开方式 1：当前窗口 2：新窗口弹出 */
    @Column(name = "MENU_OPEN_WAY", nullable = true, length = 2)
    private String menuOpenWay;

    /** 描述 */
    @Column(name = "MENU_DESC", nullable = true, length = 512)
    private String menuDesc;

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
     * 获取UUID
     * 
     * @return UUID
     */
    public String getUuid() {
        return this.uuid;
    }

    /**
     * 设置UUID
     * 
     * @param uuid
     *          UUID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取权限标识
     * 
     * @return 权限标识
     */
    public String getMenuKey() {
        return this.menuKey;
    }

    /**
     * 设置权限标识
     * 
     * @param menuKey
     *          权限标识
     */
    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    /**
     * 获取权限名称
     * 
     * @return 权限名称
     */
    public String getMenuName() {
        return this.menuName;
    }

    /**
     * 设置权限名称
     * 
     * @param menuName
     *          权限名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取父级权限
     * 
     * @return 父级权限
     */
    public String getMenuParent() {
        return this.menuParent;
    }

    /**
     * 设置父级权限
     * 
     * @param menuParent
     *          父级权限
     */
    public void setMenuParent(String menuParent) {
        this.menuParent = menuParent;
    }

    /**
     * 获取顺序序号
     * 
     * @return 顺序序号
     */
    public Integer getMenuOrde() {
        return this.menuOrde;
    }

    /**
     * 设置顺序序号
     * 
     * @param menuOrde
     *          顺序序号
     */
    public void setMenuOrde(Integer menuOrde) {
        this.menuOrde = menuOrde;
    }

    /**
     * 获取权限类型 1：菜单组  2：菜单  3：按钮
     * 
     * @return 权限类型 1
     */
    public String getMenuType() {
        return this.menuType;
    }

    /**
     * 设置权限类型 1：菜单组  2：菜单  3：按钮
     * 
     * @param menuType
     *          权限类型 1
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取图标
     * 
     * @return 图标
     */
    public String getMenuIcon() {
        return this.menuIcon;
    }

    /**
     * 设置图标
     * 
     * @param menuIcon
     *          图标
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * 获取菜单地址
     * 
     * @return 菜单地址
     */
    public String getMenuUrl() {
        return this.menuUrl;
    }

    /**
     * 设置菜单地址
     * 
     * @param menuUrl
     *          菜单地址
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 获取是否可见
     * 
     * @return 是否可见
     */
    public String getMenuVisible() {
        return this.menuVisible;
    }

    /**
     * 设置是否可见
     * 
     * @param menuVisible
     *          是否可见
     */
    public void setMenuVisible(String menuVisible) {
        this.menuVisible = menuVisible;
    }

    /**
     * 获取菜单打开方式 1：当前窗口 2：新窗口弹出
     * 
     * @return 菜单打开方式 1
     */
    public String getMenuOpenWay() {
        return this.menuOpenWay;
    }

    /**
     * 设置菜单打开方式 1：当前窗口 2：新窗口弹出
     * 
     * @param menuOpenWay
     *          菜单打开方式 1
     */
    public void setMenuOpenWay(String menuOpenWay) {
        this.menuOpenWay = menuOpenWay;
    }

    /**
     * 获取描述
     * 
     * @return 描述
     */
    public String getMenuDesc() {
        return this.menuDesc;
    }

    /**
     * 设置描述
     * 
     * @param menuDesc
     *          描述
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
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