/*
Navicat MySQL Data Transfer

Source Server         : Nav_Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sunrise

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-07-10 16:45:50
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
-- Records of log_oper
-- ----------------------------
INSERT INTO `log_oper` VALUES ('402894816bb6beb2016bb747ce840013', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562148064085', '815', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bb6beb2016bb74c2d5f001e', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562148351323', '4', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bb6beb2016bb74f71800023', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562148564575', '800', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bb6beb2016bb74ff0f8002b', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562148598004', '3', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bbabbde016bbac7313c0000', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562206744080', '807', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bc23cd8016bc26bced10005', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562334972901', '747', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bcc6d62016bcccd24a50003', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562509123813', '960', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bcc6d62016bcccd33c80004', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562509128638', '10', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bcc6d62016bccd38ba9000e', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562509544357', '3', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bcc6d62016bccd39938000f', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562509547827', '5', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bd4971e016bd49ccd120001', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562640173347', '1006', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bd65d2e016bd66b43490000', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562670481367', '877', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bd65d2e016bd6812b88000c', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562671917940', '19', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bd70558016bd71007ac0000', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) sunrise/1.0.0 Chrome/59.0.3071.115 Electron/1.8.8 Safari/537.36', '1562681279457', '967', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bda0c7b016bda55d4de0000', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562736185749', '839', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bda0c7b016bdb01fb77001f', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562747468635', '28', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bda0c7b016bdb06046a0031', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562747733079', '18', '200', '请求处理成功', 'admin', null);
INSERT INTO `log_oper` VALUES ('402894816bda0c7b016bdb06440a0032', '/logs/operMgr/queryLogOper', '查询交互日志', '192.168.199.222', 'GIGABYTE-B85', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36', '1562747749382', '3', '200', '请求处理成功', 'admin', null);

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
-- Records of log_quartz
-- ----------------------------
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb04b63d0020', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747646042', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb04c9f70021', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747651032', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb04dd1b0022', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747656027', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb04f0b80023', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747661036', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb0504260024', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747666031', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb0517b60025', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747671032', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb052b4b0026', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747676034', '1');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb053ebf0027', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747681028', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb0552700028', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747686055', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb0565e80029', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747691041', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb057967002a', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747696034', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb058cee002b', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747701028', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb05a0c5002c', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747706030', '1');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb05b45b002d', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747711041', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb05c7e1002e', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747716035', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb05db30002f', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747721028', '0');
INSERT INTO `log_quartz` VALUES ('402894816bda0c7b016bdb05eed50030', '吃鸡任务', 'test', 'GIGABYTE-B85.lan', '192.168.199.222', '1', null, '1562747726029', '0');

-- ----------------------------
-- Table structure for pdman_db_version
-- ----------------------------
DROP TABLE IF EXISTS `pdman_db_version`;
CREATE TABLE `pdman_db_version` (
  `DB_VERSION` varchar(256) DEFAULT NULL,
  `VERSION_DESC` varchar(1024) DEFAULT NULL,
  `CREATED_TIME` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdman_db_version
-- ----------------------------
INSERT INTO `pdman_db_version` VALUES ('v0.0.6', '111', '2019-06-26 00:05:08');

-- ----------------------------
-- Table structure for qtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qtz_blob_triggers`;
CREATE TABLE `qtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qtz_calendars`;
CREATE TABLE `qtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qtz_cron_triggers`;
CREATE TABLE `qtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_cron_triggers
-- ----------------------------
INSERT INTO `qtz_cron_triggers` VALUES ('clusteredScheduler', 'trigger_bbbbb', 'trigger_bbbbbb', '* * * * * ?', 'Asia/Shanghai');
INSERT INTO `qtz_cron_triggers` VALUES ('clusteredScheduler', 'trigger_bbbbb', 'trigger_bbbbbbvvvv', '1/5 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qtz_cron_triggers` VALUES ('clusteredScheduler', 'trigger_vvvv', 'trigger_vvvv', '* * * * * ?', 'Asia/Shanghai');
INSERT INTO `qtz_cron_triggers` VALUES ('clusteredScheduler', 'trigger_吃鸡任务', 'trigger_test', '1/5 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qtz_fired_triggers`;
CREATE TABLE `qtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qtz_job_details`;
CREATE TABLE `qtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_job_details
-- ----------------------------
INSERT INTO `qtz_job_details` VALUES ('clusteredScheduler', 'bbbbb', 'bbbbbb', '', 'com.sunrise.config.job.SuccessJob', '1', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007800);
INSERT INTO `qtz_job_details` VALUES ('clusteredScheduler', 'bbbbb', 'bbbbbbvvvv', '', 'com.sunrise.config.job.SuccessJob', '1', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007800);
INSERT INTO `qtz_job_details` VALUES ('clusteredScheduler', 'vvvv', 'vvvv', '', 'com.sunrise.config.job.SuccessJob', '1', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007800);
INSERT INTO `qtz_job_details` VALUES ('clusteredScheduler', '吃鸡任务', 'test', '', 'com.sunrise.config.job.SuccessJob', '1', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007800);

-- ----------------------------
-- Table structure for qtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qtz_locks`;
CREATE TABLE `qtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_locks
-- ----------------------------
INSERT INTO `qtz_locks` VALUES ('clusteredScheduler', 'STATE_ACCESS');
INSERT INTO `qtz_locks` VALUES ('clusteredScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qtz_paused_trigger_grps`;
CREATE TABLE `qtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qtz_scheduler_state`;
CREATE TABLE `qtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_scheduler_state
-- ----------------------------
INSERT INTO `qtz_scheduler_state` VALUES ('clusteredScheduler', 'GIGABYTE-B851562748323729', '1562748346311', '10000');

-- ----------------------------
-- Table structure for qtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qtz_simple_triggers`;
CREATE TABLE `qtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qtz_simprop_triggers`;
CREATE TABLE `qtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qtz_triggers`;
CREATE TABLE `qtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  CONSTRAINT `qtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qtz_triggers
-- ----------------------------
INSERT INTO `qtz_triggers` VALUES ('clusteredScheduler', 'trigger_bbbbb', 'trigger_bbbbbb', 'bbbbb', 'bbbbbb', null, '1562067653000', '-1', '0', 'PAUSED', 'CRON', '1562067653000', '0', null, '2', '');
INSERT INTO `qtz_triggers` VALUES ('clusteredScheduler', 'trigger_bbbbb', 'trigger_bbbbbbvvvv', 'bbbbb', 'bbbbbbvvvv', null, '1562124291000', '1562124286000', '0', 'PAUSED', 'CRON', '1562124159000', '0', null, '2', '');
INSERT INTO `qtz_triggers` VALUES ('clusteredScheduler', 'trigger_vvvv', 'trigger_vvvv', 'vvvv', 'vvvv', null, '1562065423000', '-1', '0', 'PAUSED', 'CRON', '1562065423000', '0', null, '2', '');
INSERT INTO `qtz_triggers` VALUES ('clusteredScheduler', 'trigger_吃鸡任务', 'trigger_test', '吃鸡任务', 'test', null, '1562747731000', '1562747726000', '0', 'PAUSED', 'CRON', '1562747527000', '0', null, '2', '');

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
-- Records of sys_dict_group
-- ----------------------------
INSERT INTO `sys_dict_group` VALUES ('402894816baad362016bab1582410000', '账户状态', 'AcStat', '1', '1', '11111111', '1561943441982', '11111111', '1561973127901');
INSERT INTO `sys_dict_group` VALUES ('402894816bb00feb016bb06069d50000', '任务运行状态', 'QuartzRunStat', '1', '1', '11111111', '1562032237012', '11111111', '1562032237012');
INSERT INTO `sys_dict_group` VALUES ('402894816bb07f03016bb08084790000', 'Quartz调度器Misfire规则', 'QuartzMisfire', '1', '1', '11111111', '1562034340983', '11111111', '1562034340983');
INSERT INTO `sys_dict_group` VALUES ('402894816bb5cc1d016bb5ffc2570062', 'Quartz日志等级', 'LogLeve', '1', '1', '11111111', '1562126565975', '11111111', '1562126565975');
INSERT INTO `sys_dict_group` VALUES ('402894816bc23cd8016bc2692d590002', '性别', 'Sex', '1', '1', 'admin', '1562334801241', 'admin', '1562381280740');
INSERT INTO `sys_dict_group` VALUES ('402894816bd4971e016bd4b00e330002', '文件状态', 'FileStat', '1', '1', 'admin', '1562641436210', 'admin', '1562641436210');
INSERT INTO `sys_dict_group` VALUES ('402894816bd65d2e016bd66f41f10001', '资源类型', 'PermType', '1', '1', 'admin', '1562670744049', 'admin', '1562670744049');
INSERT INTO `sys_dict_group` VALUES ('402894816bd65d2e016bd670cfb10003', '权限状态', 'PermStat', '1', '1', 'admin', '1562670845873', 'admin', '1562670845873');
INSERT INTO `sys_dict_group` VALUES ('402894816bd65d2e016bd676ddc90006', '字典类型', 'DictType', '1', '1', 'admin', '1562671242696', 'admin', '1562671242696');
INSERT INTO `sys_dict_group` VALUES ('402894816bd65d2e016bd67a8c2d0009', '字典组状态', 'GroupStat', '1', '1', 'admin', '1562671483949', 'admin', '1562671483949');

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
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES ('402894816b9d51b7016b9de2db940022', '402894816b9d51b7016b9d6b66c6000f', 'aaa', 'aa', 'aa', '1', '1561722015252', '1', '11111111', '1561722018708', '11111111', '1561722830166');
INSERT INTO `sys_dict_item` VALUES ('402894816b9d51b7016b9de2ec6c0023', '402894816b9d51b7016b9d6b66c6000f', '新增节点', 'null', 'null', '0', '1561722019060', '1', '11111111', '1561722023020', '11111111', '1561722830165');
INSERT INTO `sys_dict_item` VALUES ('402894816b9d51b7016b9de2f2f00024', '402894816b9d51b7016b9d6b66c6000f', 'bb', 'bb', 'bb', '0', '402894816b9d51b7016b9de2db940022', '1', '11111111', '1561722024688', '11111111', '1561722830167');
INSERT INTO `sys_dict_item` VALUES ('402894816b9d51b7016b9de2fffd0026', '402894816b9d51b7016b9d6b66c6000f', 'cc', 'cc', 'cc', '1', '402894816b9d51b7016b9de2f2f00024', '1', '11111111', '1561722028028', '11111111', '1561722830169');
INSERT INTO `sys_dict_item` VALUES ('402894816b9d51b7016b9de4325f0028', '402894816b9d51b7016b9d6b66c6000f', '新增节点', 'null', 'null', '0', '402894816b9d51b7016b9de2f2f00024', '1', '11111111', '1561722106463', '11111111', '1561722830168');
INSERT INTO `sys_dict_item` VALUES ('402894816baad362016bab16270f0001', '402894816baad362016bab1582410000', '正常', '1', '正常', '0', '', '1', '11111111', '1561943484175', '11111111', '1561943484175');
INSERT INTO `sys_dict_item` VALUES ('402894816baad362016bab16840e0002', '402894816baad362016bab1582410000', '锁定', '2', '锁定', '0', '', '1', '11111111', '1561943507982', 'admin', '1562334456674');
INSERT INTO `sys_dict_item` VALUES ('402894816baad362016bab16d42b0003', '402894816baad362016bab1582410000', '注销', '3', '注销', '0', '', '1', '11111111', '1561943528491', '11111111', '1561943528491');
INSERT INTO `sys_dict_item` VALUES ('402894816baad362016babb7413b0005', '402894816baad362016babb71f540004', '1', '1', '1', '0', '1561954039419', '1', '11111111', '1561954042171', '11111111', '1561954113043');
INSERT INTO `sys_dict_item` VALUES ('402894816baad362016babb7abab0006', '402894816baad362016babb71f540004', '11', '11', '11', '0', '402894816baad362016babb7413b0005', '1', '11111111', '1561954069419', '11111111', '1561954113044');
INSERT INTO `sys_dict_item` VALUES ('402894816baad362016babb7d4440007', '402894816baad362016babb71f540004', '2', '2', '2', '1', '1561954077165', '1', '11111111', '1561954079811', '11111111', '1561954113046');
INSERT INTO `sys_dict_item` VALUES ('402894816baad362016babb7ffb90008', '402894816baad362016babb71f540004', '22', '22', '22', '0', '402894816baad362016babb7d4440007', '1', '11111111', '1561954090937', '11111111', '1561954113047');
INSERT INTO `sys_dict_item` VALUES ('402894816bb00feb016bb061bc4e0001', '402894816bb00feb016bb06069d50000', '等待', '3', '等待', '0', '', '1', '11111111', '1562032323662', '11111111', '1562032756954');
INSERT INTO `sys_dict_item` VALUES ('402894816bb00feb016bb061f8fc0002', '402894816bb00feb016bb06069d50000', '暂停', '2', '暂停', '0', '', '1', '11111111', '1562032339195', '11111111', '1562032745189');
INSERT INTO `sys_dict_item` VALUES ('402894816bb00feb016bb0622c460003', '402894816bb00feb016bb06069d50000', '正常', '1', '正常', '0', '', '1', '11111111', '1562032352326', '11111111', '1562032732964');
INSERT INTO `sys_dict_item` VALUES ('402894816bb00feb016bb06262860004', '402894816bb00feb016bb06069d50000', '阻塞', '4', '阻塞', '0', '', '1', '11111111', '1562032366214', '11111111', '1562032767087');
INSERT INTO `sys_dict_item` VALUES ('402894816bb00feb016bb06295cc0005', '402894816bb00feb016bb06069d50000', '错误', '5', '错误', '0', '', '1', '11111111', '1562032379340', '11111111', '1562032773703');
INSERT INTO `sys_dict_item` VALUES ('402894816bb07f03016bb082ba090001', '402894816bb07f03016bb08084790000', 'WithMisfireHandlingInstructionDoNothing ', '1', '不触发立即执行,等待下次Cron触发频率到达时刻开始按照Cron频率依次执行', '0', '', '1', '11111111', '1562034485769', '11111111', '1562034485769');
INSERT INTO `sys_dict_item` VALUES ('402894816bb07f03016bb083b81f0002', '402894816bb07f03016bb08084790000', 'WithMisfireHandlingInstructionFireAndPro', '2', '以当前时间为触发频率立刻触发一次执行,然后按照Cron频率依次执行', '0', '', '1', '11111111', '1562034550814', '11111111', '1562034550815');
INSERT INTO `sys_dict_item` VALUES ('402894816bb07f03016bb084d9900003', '402894816bb07f03016bb08084790000', 'WithMisfireHandlingInstructionIgnoreMisf', '3', '以错过的第一个频率时间立刻开始执行,重做错过的所有频率周期后,当下一次触发频率发', '0', '', '1', '11111111', '1562034624911', '11111111', '1562034624911');
INSERT INTO `sys_dict_item` VALUES ('402894816bb5cc1d016bb6001b220063', '402894816bb5cc1d016bb5ffc2570062', '系统记录', '1', '系统记录', '0', '', '1', '11111111', '1562126588706', '11111111', '1562126588706');
INSERT INTO `sys_dict_item` VALUES ('402894816bb5cc1d016bb6005bc50064', '402894816bb5cc1d016bb5ffc2570062', '手动记录', '2', '手动记录', '0', '', '1', '11111111', '1562126605251', '11111111', '1562126605252');
INSERT INTO `sys_dict_item` VALUES ('402894816bc23cd8016bc2697c7e0003', '402894816bc23cd8016bc2692d590002', '男', '1', '男', '0', '', '1', 'admin', '1562334821501', 'admin', '1562334821502');
INSERT INTO `sys_dict_item` VALUES ('402894816bc23cd8016bc269c1cf0004', '402894816bc23cd8016bc2692d590002', '女', '2', '女', '0', '', '1', 'admin', '1562334839247', 'admin', '1562334839247');
INSERT INTO `sys_dict_item` VALUES ('402894816bd4971e016bd4b0bc710003', '402894816bd4971e016bd4b00e330002', '共有', '1', '共有', '0', '', '1', 'admin', '1562641480817', 'admin', '1562641480817');
INSERT INTO `sys_dict_item` VALUES ('402894816bd4971e016bd4b0fb600004', '402894816bd4971e016bd4b00e330002', '私有', '2', '私有', '0', '', '1', 'admin', '1562641496927', 'admin', '1562641496928');
INSERT INTO `sys_dict_item` VALUES ('402894816bd65d2e016bd66f966e0002', '402894816bd65d2e016bd66f41f10001', '菜单', '1', '菜单', '0', '', '1', 'admin', '1562670765678', 'admin', '1562671014048');
INSERT INTO `sys_dict_item` VALUES ('402894816bd65d2e016bd67135140004', '402894816bd65d2e016bd670cfb10003', '正常', '1', '正常', '0', '', '1', 'admin', '1562670871827', 'admin', '1562671041749');
INSERT INTO `sys_dict_item` VALUES ('402894816bd65d2e016bd67161170005', '402894816bd65d2e016bd670cfb10003', '禁用', '2', '菜单', '0', '', '1', 'admin', '1562670883095', 'admin', '1562671026315');
INSERT INTO `sys_dict_item` VALUES ('402894816bd65d2e016bd67729dd0007', '402894816bd65d2e016bd676ddc90006', '列表', '1', '列表', '0', '', '1', 'admin', '1562671262173', 'admin', '1562671262173');
INSERT INTO `sys_dict_item` VALUES ('402894816bd65d2e016bd6777e430008', '402894816bd65d2e016bd676ddc90006', '树', '2', '树', '0', '', '1', 'admin', '1562671283779', 'admin', '1562671283779');
INSERT INTO `sys_dict_item` VALUES ('402894816bd65d2e016bd67b2f8e000a', '402894816bd65d2e016bd67a8c2d0009', '正常', '1', '正常', '0', '', '1', 'admin', '1562671525774', 'admin', '1562671525774');
INSERT INTO `sys_dict_item` VALUES ('402894816bd65d2e016bd67b659a000b', '402894816bd65d2e016bd67a8c2d0009', '禁用', '2', '禁用', '0', '', '1', 'admin', '1562671539610', 'admin', '1562671539610');

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
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('402894816bda0c7b016bdb07d7e70033', 'maven打包命令.txt', 'e078a83395049192213a334649bc6d81', '.\\filestore\\2019\\07\\10\\maven打包命令.a855f7da3bc846bc86b40bfdfd3c4170.txt', '/sysm/fileMgr/anon/downFile/e078a83395049192213a334649bc6d81', 'unknow', '110', '2', 'admin', '1562747852775', 'admin', '1562747852775');
INSERT INTO `sys_file` VALUES ('402894816bda0c7b016bdb07d7f90034', 'Quartz-中文注释.sql', 'd4b15ef5421d94d10a151ab91687a7e4', '.\\filestore\\2019\\07\\10\\Quartz-中文注释.9d2a018e571841c58b987a2b46c69f34.sql', '/sysm/fileMgr/anon/downFile/d4b15ef5421d94d10a151ab91687a7e4', 'unknow', '13407', '2', 'admin', '1562747852790', 'admin', '1562747852792');
INSERT INTO `sys_file` VALUES ('402894816bda0c7b016bdb07d8d40035', '73f1fd49932865.58c24ccb3f3f9.jpg', 'bbe7cf42b0d26f7f18f8fd3735646e2c', '.\\filestore\\2019\\07\\10\\73f1fd49932865.58c24ccb3f3f9.f5df595b35ab4dfea37d80c9a8272ad4.jpg', '/sysm/fileMgr/anon/downFile/bbe7cf42b0d26f7f18f8fd3735646e2c', 'unknow', '928290', '2', 'admin', '1562747853012', 'admin', '1562747853012');

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
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5878570001', '/usrm', '账户管理', '', '0', '1', 'el-icon-postcard', '/usrm', '1', '1', '', 'admin', '1562736359511', 'admin', '1562736384169');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5879510002', 'usermgr', '用户管理', '/usrm', '0', '2', 'el-icon-s-custom', '/usrm/usermgr', '1', '1', '', 'admin', '1562736359760', 'admin', '1562736384170');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5879ca0003', 'rolemgr', '角色管理', '/usrm', '1', '2', 'el-icon-user', '/usrm/rolemgr', '1', '1', '', 'admin', '1562736359882', 'admin', '1562736384172');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda587aaf0004', 'orgmgr', '组织管理', '/usrm', '2', '2', 'icon-fa fa-sitemap', '/usrm/orgmgr', '1', '1', '', 'admin', '1562736360111', 'admin', '1562736384173');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda587b270005', 'permmgr', '权限管理', '/usrm', '3', '2', 'icon-fa fa-shield', '/usrm/permmgr', '1', '1', '', 'admin', '1562736360231', 'admin', '1562736384174');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda587c080006', '/sysm', '系统设置', '', '1', '1', 'el-icon-set-up', '/sysm', '1', '1', '', 'admin', '1562736360456', 'admin', '1562736384175');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda587c850007', 'menuMgr', '菜单管理', '/sysm', '0', '2', 'icon-fa fa-bars', '/sysm/menuMgr', '1', '1', '', 'admin', '1562736360580', 'admin', '1562736384176');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda587d6a0008', 'dictMgr', '字典管理', '/sysm', '1', '2', 'icon-fa fa-book', '/sysm/dictMgr', '1', '1', '', 'admin', '1562736360810', 'admin', '1562736384177');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda587de60009', 'fileMgr', '附件管理', '/sysm', '2', '2', 'icon-fa fa-file-o', '/sysm/fileMgr', '1', '1', '', 'admin', '1562736360934', 'admin', '1562736384178');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda587ed5000a', 'quartzmgr', '任务管理', '/sysm', '3', '2', 'el-icon-alarm-clock', '/sysm/quartzmgr', '1', '1', '', 'admin', '1562736361173', 'admin', '1562736384179');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda587f49000b', '/logs', '系统日志', '', '2', '1', 'el-icon-s-order', '/logs', '1', '1', '', 'admin', '1562736361289', 'admin', '1562736384179');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda588032000c', 'operLog', '交互日志', '/logs', '0', '2', 'el-icon-connection', '/logs/operLog', '1', '1', '', 'admin', '1562736361522', 'admin', '1562736384180');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5880b5000d', 'quartzLog', '任务日志', '/logs', '1', '2', 'el-icon-watch', '/logs/quartzLog', '1', '1', '', 'admin', '1562736361653', 'admin', '1562736384181');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda58818e000e', '/plugin', '插件示例', '', '3', '1', 'el-icon-water-cup', '/plugin', '1', '1', '', 'admin', '1562736361870', 'admin', '1562736384182');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda58820c000f', 'crontab', 'Cron生成器', '/plugin', '0', '2', 'el-icon-coffee-cup', '/plugin/crontab', '1', '1', '', 'admin', '1562736361996', 'admin', '1562736384183');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5882f50010', 'datatable', '数据分页组件', '/plugin', '1', '2', 'el-icon-cold-drink', '/plugin/datatable', '1', '1', '', 'admin', '1562736362229', 'admin', '1562736384184');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5883670011', 'iconfont', 'IconFont', '/plugin', '2', '2', 'el-icon-goblet', '/plugin/iconfont', '1', '1', '', 'admin', '1562736362343', 'admin', '1562736384185');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5884540012', 'markdown', 'Markdown', '/plugin', '3', '2', 'el-icon-refrigerator', '/plugin/markdown', '1', '1', '', 'admin', '1562736362580', 'admin', '1562736384186');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5884c30013', 'singlePageOpen/:params', '单路由多开', '/plugin', '4', '2', 'el-icon-coffee', '/plugin/singlePageOpen/:params', '1', '1', '', 'admin', '1562736362691', 'admin', '1562736384187');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5885b40014', 'jsonEditPage', 'Json编辑器', '/plugin', '5', '2', 'el-icon-lollipop', '/plugin/jsonEditPage', '1', '1', '', 'admin', '1562736362932', 'admin', '1562736384188');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5886220015', 'countToPage', '数字滚动', '/plugin', '6', '2', 'el-icon-place', '/plugin/countToPage', '1', '1', '', 'admin', '1562736363042', 'admin', '1562736384189');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5887100016', 'router1', '嵌套路由', '/plugin', '7', '1', 'el-icon-trophy', '/plugin/router1', '1', '1', '', 'admin', '1562736363280', 'admin', '1562736384190');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda58877e0017', 'router11', '路由1', '/plugin/router1', '0', '2', 'el-icon-trophy-1', '/plugin/router1/router11', '1', '1', '', 'admin', '1562736363390', 'admin', '1562736384191');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda58886f0018', 'router12', '路由2', '/plugin/router1', '1', '1', 'el-icon-first-aid-kit', '/plugin/router1/router12', '1', '1', '', 'admin', '1562736363631', 'admin', '1562736384192');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5888df0019', 'router121', '路由2-1', '/plugin/router1/router12', '0', '2', 'el-icon-discover', '/plugin/router1/router12/router121', '1', '1', '', 'admin', '1562736363743', 'admin', '1562736384193');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda5889cc001a', 'router122', '路由2-2', '/plugin/router1/router12', '1', '2', 'el-icon-medal', '/plugin/router1/router12/router122', '1', '1', '', 'admin', '1562736363980', 'admin', '1562736384194');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda588a4e001b', '/otherpage', '其它页面', '', '4', '1', 'el-icon-basketball', '/otherpage', '1', '1', '', 'admin', '1562736364110', 'admin', '1562736384195');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda588b2a001c', 'page404', '目标未找到', '/otherpage', '0', '2', 'el-icon-lightning', '/otherpage/page404', '1', '1', '', 'admin', '1562736364330', 'admin', '1562736384196');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda588bb5001d', 'page500', '服务器错误', '/otherpage', '1', '2', 'el-icon-heavy-rain', '/otherpage/page500', '1', '1', '', 'admin', '1562736364469', 'admin', '1562736384197');
INSERT INTO `sys_menu` VALUES ('402894816bda0c7b016bda588c82001e', 'baidu', 'route.Baidu', '/otherpage', '2', '2', 'el-icon-sunrise', '/otherpage/baidu', '1', '2', '', 'admin', '1562736364674', 'admin', '1562736384197');

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
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('402894816b91cffa016b9221d89b000d', 'devjob', 'ROOT', '开发部', '开发部', '', '', '', '', '', '1', '0', '11111111', '1561524820123', '11111111', '1561551227315');
INSERT INTO `sys_org` VALUES ('402894816b91cffa016b922257b2000e', 'projob', 'ROOT', '营销部', '营销部', '', '', '', '', '', '1', '0', '11111111', '1561524852658', '11111111', '1561524852658');
INSERT INTO `sys_org` VALUES ('402894816b91cffa016b9222c3db000f', 'a', 'devjob', 'A部', 'A部', '', '', '', '', '', '1', '0', '11111111', '1561524880347', '11111111', '1561551178550');
INSERT INTO `sys_org` VALUES ('402894816b91cffa016b92240ce10010', 'b', 'a', 'B部', 'B部', '', '', '', '', '', '1', '0', '11111111', '1561524964577', '11111111', '1561551245790');

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
-- Records of sys_perm
-- ----------------------------
INSERT INTO `sys_perm` VALUES ('402894816b927d36016b92ed27690006', '1', 'SYS_MENU', '1', '324252342532432524325', '11111111', '1561538144105', '11111111', '1561651552856');

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
-- Records of sys_quartz
-- ----------------------------
INSERT INTO `sys_quartz` VALUES ('402894816bb24075016bb25acb720002', '吃鸡任务', 'test', '2', 'com.sunrise.config.job.SuccessJob', '1/5 * * * * ?', '0', '', '1', null, '', '11111111', '1562065423218', 'admin', '1562747729045');

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
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('402894816bda0c7b016bdb0a4c4a0036', '402894816b91cffa016b9222c3db000f', 'test', 'test', '', null, 'admin', '1562748013642', 'admin', '1562748013642');
INSERT INTO `sys_role` VALUES ('402894816bda0c7b016bdb0aa4c00055', '402894816b91cffa016b92240ce10010', 'dev', 'dev', '', null, 'admin', '1562748036288', 'admin', '1562748036288');

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
-- Records of sys_role_perm
-- ----------------------------
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1bc6b90011', '402894816b969821016b9705c0c00001', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c0220002', '11111111', '1561692194489', '11111111', '1561692194489');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1bc6ba0012', '402894816b969821016b9705c0c00001', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c44e0005', '11111111', '1561692194490', '11111111', '1561692194490');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1bdf3a0013', '402894816b969821016b9705e9b40002', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198beb50001', '11111111', '1561692200761', '11111111', '1561692200761');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1bdf3a0014', '402894816b969821016b9705e9b40002', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c2e90004', '11111111', '1561692200762', '11111111', '1561692200762');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1bdf3a0015', '402894816b969821016b9705e9b40002', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c44e0005', '11111111', '1561692200762', '11111111', '1561692200762');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1bf7430016', '402894816b988fcd016b991876270000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c8710008', '11111111', '1561692206915', '11111111', '1561692206915');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1c0e490017', '402894816b969821016b9705798e0000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198beb50001', '11111111', '1561692212809', '11111111', '1561692212809');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1c0e490018', '402894816b969821016b9705798e0000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c0220002', '11111111', '1561692212809', '11111111', '1561692212809');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1c0e490019', '402894816b969821016b9705798e0000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c1830003', '11111111', '1561692212809', '11111111', '1561692212809');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1c0e4a001a', '402894816b969821016b9705798e0000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c2e90004', '11111111', '1561692212809', '11111111', '1561692212809');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1c0e4a001b', '402894816b969821016b9705798e0000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c44e0005', '11111111', '1561692212810', '11111111', '1561692212810');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1c0e4a001c', '402894816b969821016b9705798e0000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c5b20006', '11111111', '1561692212810', '11111111', '1561692212810');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1c0e4a001d', '402894816b969821016b9705798e0000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c7130007', '11111111', '1561692212810', '11111111', '1561692212810');
INSERT INTO `sys_role_perm` VALUES ('402894816b9c0639016b9c1c0e4a001e', '402894816b969821016b9705798e0000', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c8710008', '11111111', '1561692212810', '11111111', '1561692212810');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d25280008', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198bd1a0000', '11111111', '1561864250664', '11111111', '1561864250664');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d25290009', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198beb50001', '11111111', '1561864250665', '11111111', '1561864250665');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d2529000a', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c0220002', '11111111', '1561864250665', '11111111', '1561864250665');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d2529000b', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c1830003', '11111111', '1561864250665', '11111111', '1561864250665');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d2529000c', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c2e90004', '11111111', '1561864250665', '11111111', '1561864250665');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d252a000d', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c44e0005', '11111111', '1561864250665', '11111111', '1561864250665');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d252a000e', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c5b20006', '11111111', '1561864250666', '11111111', '1561864250666');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d252b000f', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c7130007', '11111111', '1561864250666', '11111111', '1561864250667');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d252b0010', '402894816ba617f6016ba622a8770008', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c8710008', '11111111', '1561864250667', '11111111', '1561864250667');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f710011', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198bd1a0000', '11111111', '1561864273777', '11111111', '1561864273777');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f720012', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198beb50001', '11111111', '1561864273777', '11111111', '1561864273777');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f720013', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c0220002', '11111111', '1561864273778', '11111111', '1561864273778');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f720014', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c1830003', '11111111', '1561864273778', '11111111', '1561864273778');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f720015', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c2e90004', '11111111', '1561864273778', '11111111', '1561864273778');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f720016', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c44e0005', '11111111', '1561864273778', '11111111', '1561864273778');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f720017', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c5b20006', '11111111', '1561864273778', '11111111', '1561864273778');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f720018', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c7130007', '11111111', '1561864273778', '11111111', '1561864273778');
INSERT INTO `sys_role_perm` VALUES ('402894816ba62554016ba65d7f730019', '402894816b9c0639016b9c21c6f1001f', '402894816b927d36016b92ed27690006', '402894816b9190a6016b9198c8710008', '11111111', '1561864273779', '11111111', '1561864273779');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8b0037', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5878570001', 'admin', '1562748013707', 'admin', '1562748013707');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8b0038', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5879510002', 'admin', '1562748013707', 'admin', '1562748013707');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c0039', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5879ca0003', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c003a', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587aaf0004', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c003b', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587b270005', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c003c', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587c080006', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c003d', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587c850007', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c003e', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587d6a0008', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c003f', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587de60009', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c0040', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587ed5000a', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c0041', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587f49000b', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c0042', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588032000c', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c0043', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5880b5000d', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c0044', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda58818e000e', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8c0045', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda58820c000f', 'admin', '1562748013708', 'admin', '1562748013708');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8d0046', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5882f50010', 'admin', '1562748013709', 'admin', '1562748013709');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e0047', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5883670011', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e0048', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5884540012', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e0049', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5884c30013', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e004a', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5885b40014', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e004b', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5886220015', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e004c', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5887100016', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e004d', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda58877e0017', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e004e', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda58886f0018', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e004f', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5888df0019', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e0050', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5889cc001a', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e0051', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588a4e001b', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e0052', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588b2a001c', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e0053', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588bb5001d', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0a4c8e0054', '402894816bda0c7b016bdb0a4c4a0036', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588c82001e', 'admin', '1562748013710', 'admin', '1562748013710');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c20056', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5878570001', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c20057', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5879510002', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c20058', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5879ca0003', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c20059', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587aaf0004', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c2005a', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587b270005', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c2005b', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587c080006', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c2005c', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587c850007', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c2005d', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587d6a0008', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c2005e', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587de60009', 'admin', '1562748036290', 'admin', '1562748036290');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c3005f', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587ed5000a', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30060', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda587f49000b', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30061', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588032000c', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30062', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5880b5000d', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30063', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda58818e000e', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30064', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda58820c000f', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30065', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5882f50010', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30066', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5883670011', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30067', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5884540012', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30068', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5884c30013', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c30069', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5885b40014', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c3006a', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5886220015', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c3006b', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5887100016', 'admin', '1562748036291', 'admin', '1562748036291');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c4006c', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda58877e0017', 'admin', '1562748036292', 'admin', '1562748036292');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c4006d', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda58886f0018', 'admin', '1562748036292', 'admin', '1562748036292');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c4006e', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5888df0019', 'admin', '1562748036292', 'admin', '1562748036292');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c4006f', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda5889cc001a', 'admin', '1562748036292', 'admin', '1562748036292');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c40070', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588a4e001b', 'admin', '1562748036292', 'admin', '1562748036292');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c40071', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588b2a001c', 'admin', '1562748036292', 'admin', '1562748036292');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c40072', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588bb5001d', 'admin', '1562748036292', 'admin', '1562748036292');
INSERT INTO `sys_role_perm` VALUES ('402894816bda0c7b016bdb0aa4c40073', '402894816bda0c7b016bdb0aa4c00055', '402894816b927d36016b92ed27690006', '402894816bda0c7b016bda588c82001e', 'admin', '1562748036292', 'admin', '1562748036292');

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
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('admin', 'admin', '1fef8f79c5a8d7dc4bdee1f41c3dc746', '1', 'sunrise', null, null, null, null, 'admin', '1562277320619');

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
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('402894816bda0c7b016bdb0c1ece0075', '402894816bda0c7b016bdb0c1ece0074', 'jake', '1', '1256789255', '123@123.com', '1563292800000', 'admin', '1562748133070', 'admin', '1562748133070');
INSERT INTO `sys_user_info` VALUES ('402894816bda0c7b016bdb0cdf680078', '402894816bda0c7b016bdb0cdf680077', 'tom', '1', '7894567233', '123@555.com', '1562601600000', 'admin', '1562748182376', 'admin', '1562748182376');
INSERT INTO `sys_user_info` VALUES ('admin', 'admin', '123122', '1', '123131', null, '1564502400000', null, null, 'admin', '1562274048804');

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

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('402894816bda0c7b016bdb0c1ed30076', '402894816bda0c7b016bdb0c1ece0074', '402894816bda0c7b016bdb0a4c4a0036', 'admin', '1562748133075', 'admin', '1562748133075');
INSERT INTO `sys_user_role` VALUES ('402894816bda0c7b016bdb0cdf6a0079', '402894816bda0c7b016bdb0cdf680077', '402894816bda0c7b016bdb0aa4c00055', 'admin', '1562748182377', 'admin', '1562748182378');
SET FOREIGN_KEY_CHECKS=1;
