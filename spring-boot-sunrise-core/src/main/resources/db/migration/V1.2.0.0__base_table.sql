/*
Navicat MySQL Data Transfer

Source Server         : Nav_Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sunrise

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-09-19 16:58:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_oper
-- ----------------------------
DROP TABLE IF EXISTS `log_oper`;
CREATE TABLE `log_oper` (
  `UUID` varchar(32) NOT NULL COMMENT '主键',
  `REQ_URL` varchar(255) DEFAULT NULL COMMENT '请求路径',
  `URL_DESC` varchar(50) DEFAULT NULL COMMENT '路径说明',
  `SVR_ADRR` varchar(20) DEFAULT NULL COMMENT '服务器地址',
  `SVR_NAME` varchar(255) DEFAULT NULL COMMENT '服务器名称',
  `CLI_ADRR` varchar(20) DEFAULT NULL COMMENT '客户端地址',
  `CLI_DESC` varchar(255) DEFAULT NULL COMMENT '客户端说明',
  `START_TIME` decimal(24,0) DEFAULT NULL COMMENT '操作开始时间',
  `PROC_TIME` decimal(24,0) DEFAULT NULL COMMENT '耗时',
  `RESP_CODE` varchar(10) DEFAULT NULL COMMENT '服务器响应代码',
  `RESP_DESC` varchar(50) DEFAULT NULL COMMENT '服务器响应说明',
  `OP_USER` varchar(50) DEFAULT NULL COMMENT '操作人',
  `EXEC_INFO` varchar(1500) DEFAULT NULL COMMENT '异常信息',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交互日志';

-- ----------------------------
-- Table structure for log_quartz
-- ----------------------------
DROP TABLE IF EXISTS `log_quartz`;
CREATE TABLE `log_quartz` (
  `UUID` varchar(32) NOT NULL COMMENT '主键',
  `QTZ_NAME` varchar(50) DEFAULT NULL COMMENT '任务名称',
  `QTZ_GROUP` varchar(50) DEFAULT NULL COMMENT '任务组',
  `SVR_NAME` varchar(50) DEFAULT NULL COMMENT '服务器名称',
  `SVR_ADDR` varchar(50) DEFAULT NULL COMMENT '服务器地址',
  `LOG_LEVE` varchar(2) DEFAULT NULL COMMENT '日记等级 1、系统记录 2、手动记录',
  `EXEC_INFO` varchar(1500) DEFAULT NULL COMMENT '异常信息',
  `START_TIME` decimal(24,0) DEFAULT NULL COMMENT '开始执行时间',
  `PROC_TIME` decimal(24,0) DEFAULT NULL COMMENT '处理耗时',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Quartz日志';

-- ----------------------------
-- Table structure for sys_dict_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_group`;
CREATE TABLE `sys_dict_group` (
  `UUID` varchar(32) NOT NULL COMMENT '主键',
  `GROUP_NAME` varchar(50) DEFAULT NULL COMMENT '字典组名称',
  `GROUP_KEY` varchar(50) DEFAULT NULL COMMENT '字典组key',
  `DICT_TYPE` varchar(2) DEFAULT NULL COMMENT '字典类型 代码类型: 1 列表类型 2 树类型',
  `GROUP_STAT` varchar(2) DEFAULT NULL COMMENT '字典组状态',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典组 ';

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `GROUP_UUID` varchar(32) DEFAULT NULL COMMENT '字典组UUID',
  `DICT_NAME` varchar(50) DEFAULT NULL COMMENT '字典名称',
  `DICT_KEY` varchar(50) DEFAULT NULL COMMENT '字典key',
  `DICT_VALUE` varchar(50) DEFAULT NULL COMMENT '字典value',
  `DICT_ORDE` int(2) DEFAULT NULL COMMENT '字典排序',
  `DICT_PUUID` varchar(32) DEFAULT NULL COMMENT '父字典 适用于树',
  `DICT_STAT` varchar(2) DEFAULT NULL COMMENT '字典状态',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典值 ';

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `FILE_NAME` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `FILE_MD5` varchar(255) DEFAULT NULL COMMENT '文件MD5',
  `FILE_PATH` varchar(255) DEFAULT NULL COMMENT '服务器存放地址',
  `FILE_URL` varchar(255) DEFAULT NULL COMMENT '外网访问地址',
  `FILE_TYPE` varchar(50) NOT NULL COMMENT '文件类型',
  `FILE_SIZE` decimal(8,0) DEFAULT NULL COMMENT '文件大小',
  `FILE_STAT` varchar(2) DEFAULT NULL COMMENT '文件状态：1、公用 2、私有',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统文件';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `UUID` varchar(32) NOT NULL COMMENT 'UUID',
  `MENU_KEY` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `MENU_NAME` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `MENU_PARENT` varchar(32) DEFAULT NULL COMMENT '父级权限',
  `MENU_ORDE` int(10) DEFAULT NULL COMMENT '顺序序号',
  `MENU_TYPE` varchar(2) DEFAULT NULL COMMENT '权限类型 1：菜单组  2：菜单  3：按钮',
  `MENU_ICON` varchar(50) DEFAULT NULL COMMENT '图标',
  `MENU_URL` varchar(50) DEFAULT NULL COMMENT '菜单地址',
  `MENU_VISIBLE` varchar(2) DEFAULT NULL COMMENT '是否可见',
  `MENU_OPEN_WAY` varchar(2) DEFAULT NULL COMMENT '菜单打开方式 1：当前窗口 2：新窗口弹出',
  `MENU_DESC` varchar(512) DEFAULT NULL COMMENT '描述',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单 ';

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `ORG_CODE` varchar(50) DEFAULT NULL COMMENT '唯一编号',
  `ORG_PARE` varchar(50) DEFAULT NULL COMMENT '父组织',
  `ORG_NAME` varchar(50) DEFAULT NULL COMMENT '组织名称',
  `ORG_BRF_NAME` varchar(50) DEFAULT NULL COMMENT '组织简称',
  `ORG_DESC` varchar(512) DEFAULT NULL COMMENT '组织描述',
  `ORG_MAST` varchar(50) DEFAULT NULL COMMENT '组织负责人',
  `ORG_ADDR` varchar(50) DEFAULT NULL COMMENT '组织地址',
  `ORG_POST` varchar(50) DEFAULT NULL COMMENT '组织邮编',
  `ORG_PHONE` varchar(50) DEFAULT NULL COMMENT '组织电话',
  `ORG_STAT` varchar(2) DEFAULT NULL COMMENT '组织状态 1、正常 2、禁用 3、注销',
  `ORG_ORDE` int(10) DEFAULT NULL COMMENT '组织排序',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织管理 ';

-- ----------------------------
-- Table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `PERM_TYPE` varchar(50) DEFAULT NULL COMMENT '资源类型',
  `PERM_TABLE` varchar(50) DEFAULT NULL COMMENT '权限资源隶属表',
  `PERM_STAT` varchar(2) DEFAULT NULL COMMENT '权限状态 1、正常 2、禁用',
  `PERM_DESC` varchar(50) DEFAULT NULL COMMENT '权限描述',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限 ';

-- ----------------------------
-- Table structure for sys_quartz
-- ----------------------------
DROP TABLE IF EXISTS `sys_quartz`;
CREATE TABLE `sys_quartz` (
  `UUID` varchar(32) NOT NULL COMMENT '主键',
  `QUARTZ_NAME` varchar(200) NOT NULL COMMENT '任务名称',
  `QUARTZ_GROUP` varchar(200) NOT NULL COMMENT '任务组',
  `QUARTZ_STAT` varchar(16) DEFAULT NULL COMMENT '执行状态',
  `QUARTZ_CLASS` varchar(250) DEFAULT NULL COMMENT '执行类路径',
  `QUARTZ_CRON` varchar(120) DEFAULT NULL COMMENT 'cron表达式',
  `QUARTZ_PRIORITY` int(2) DEFAULT NULL COMMENT '优先级',
  `QUARTZ_PARAMS` varchar(255) DEFAULT NULL COMMENT '初始参数',
  `QUARTZ_MISFIRE` varchar(10) DEFAULT NULL COMMENT '执行规则',
  `QUARTZ_EXCE` varchar(1500) DEFAULT NULL COMMENT '任务异常',
  `QUARTZ_DESC` varchar(255) DEFAULT NULL COMMENT '任务说明',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统任务';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `ORG_UUID` varchar(50) DEFAULT NULL COMMENT '隶属组织',
  `ROLE_CODE` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `ROLE_NAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `ROLE_PARE` varchar(50) DEFAULT NULL COMMENT '角色继承',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色 ';

-- ----------------------------
-- Table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `ROLE_UUID` varchar(32) NOT NULL COMMENT '角色主键',
  `PERM_UUID` varchar(32) NOT NULL COMMENT '权限主键',
  `RESO_UUID` varchar(32) DEFAULT NULL COMMENT '权限资源主键',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表 ';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `AC_NAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `AC_PWD` varchar(50) DEFAULT NULL COMMENT '密码',
  `AC_STAT` varchar(2) DEFAULT NULL COMMENT '状态 1、正常 2、锁定 3、注销',
  `ENC_SALT` varchar(50) DEFAULT NULL COMMENT '盐',
  `ORG_UUID` varchar(32) DEFAULT NULL COMMENT '隶属组织',
  `LAST_LOG_DATE` decimal(24,0) DEFAULT NULL COMMENT '最后登录时间',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表 ';

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `USER_UUID` varchar(32) DEFAULT NULL COMMENT '用户的uuid',
  `USER_NAME` varchar(50) DEFAULT NULL,
  `USER_SEX` varchar(3) DEFAULT NULL COMMENT '性别',
  `USER_PHONE` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `USER_EMAIL` varchar(32) DEFAULT NULL COMMENT '邮件',
  `USER_BIRTHDAY` decimal(32,0) DEFAULT NULL COMMENT '出生年月日',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户信息 ';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `UUID` varchar(32) NOT NULL COMMENT '表主键',
  `USER_UUID` varchar(32) NOT NULL COMMENT '用户主键',
  `ROLE_UUID` varchar(32) NOT NULL COMMENT '角色主键',
  `CREATED_USER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '创建时间',
  `UPDATED_USER` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` decimal(24,0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关联表 ';
SET FOREIGN_KEY_CHECKS=1;
