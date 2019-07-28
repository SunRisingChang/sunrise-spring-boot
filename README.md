<h1 align="center">
  <img width="100" height='100' src="./docs/img/logo.png">
</h1>

<h1 align="center">
  S U N R I S E
</h1>

<p align="center">
  <a href="https://github.com/vuejs/vue">
    <img src="https://img.shields.io/badge/vue-2.6.10-brightgreen.svg" alt="vue">
  </a>
  <a href="https://github.com/ElemeFE/element">
    <img src="https://img.shields.io/badge/element--ui-2.10.0-brightgreen.svg" alt="element-ui">
  </a>
  <a href="https://spring.io/projects/spring-boot/#learn">
    <img src="https://img.shields.io/badge/spring--boot-2.1.6-brightgreen.svg" alt="license">
  </a>
  <a href="LICENSE">
    <img src="https://img.shields.io/github/license/mashape/apistatus.svg" alt="license">
  </a>
</p>

简体中文

## 简介

[spring-boot-sunrise](https://gitee.com/sunrise-chang/spring-boot-sunrise) 是 SUNRISE 系列项目的前端和[electron-vue-sunrise](https://gitee.com/sunrise-chang/electron-vue-sunrise)是姊妹项目，该项目是一个前端后台解决方案，它基于 [spring boot](https://spring.io/projects/spring-boot/) 实现。它使用了最新的技术栈，内置了权限验证，统一异常处理，交互日志记录等，提炼了典型的业务模型，它可以帮助你快速搭建企业级中后台产品原型。相信不管你的需求是什么，本项目都能帮助到你。

## 活动圈

- QQ 技术交流群 [678251003]
- 邮箱[Sun_Rising_Chang@hotmail.com]

## 前序准备

你需要在本地安装 [JDK8](https://www.oracle.com/technetwork/cn/java/javase/downloads/jdk8-downloads-2133151-zhs.html) 和 Mysq 推荐使用 [appserv](https://www.appserv.org/en/)来安装 Mysq 因为它是精简的。本项目是由 [Maven](http://maven.apache.org/)构建。

## 功能

针对[electron-vue-sunrise](https://gitee.com/sunrise-chang/electron-vue-sunrise)项目的功能接口实现

```bash
- ResponseBodyAdvice 返回统一的服务器响应格式

- @ControllerAdvice 统一处理异常信息（Throwable）

- Ehcache 本地缓存

- LogOper 交互日志注解

- DataPage 支持多种数据库进行分页查询
	- MySQL
	- Oracle
	- Db2
	- Hsqldb
	- Informix
	- SqlServer

- DictCacheService 字典缓存服务
	- 字典数据更新时会向前端推送通知，由前端处理前端缓存

- CustomRuntimeException 自定义异常类 (进行统一捕获)

- FastJson
	- 替换 spring web HttpMessageConverter
	- 实现 RedisSerializer 接口

- Kaptcha 图片验证码

- FrontLog 前端日志文件存储

- Quartz 定时任务

- RabbitMq 中间件(已配置，未使用)

- Redis 服务器缓存(已配置，未使用)

- HandlerMethodArgumentResolver 自定义参数解析器(post传送的实体需实现PostEntity接口)

- Shiro 访问控制
	- 登录次数限制

- WebSocket 长连接信息接收和发送

```

## 项目说明

```bash
# 公共依赖管理模块
spring-boot-sunrise-parent

# 核心模块
spring-boot-sunrise-core

# 待开发模块，二次开发应在该包中进行
spring-boot-sunrise-console

```

## 运行

```bash
运行 spring-boot-sunrise-console 包下的 SpringBootConsoleApplication 类

```

## 赞助商

成为赞助商并在 GitHub 上的 README 上获取您的徽标，并附上指向您网站的链接。

## 支持一下

如果你觉得这个项目帮助到了你，你可以帮作者买一杯果汁表示鼓励 :tropical_drink:

<h1 align="left">
  <img width="300" height='300' src="./docs/img/WeChatPlay.png">
</h1>

## License

[MIT](LICENSE)

Copyright (c) 2019-present SunRise
