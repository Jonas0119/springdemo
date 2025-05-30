# Spring Boot 演示项目

这是一个使用Spring Boot、Thymeleaf和Bootstrap构建的简单Web应用程序演示项目。

## 项目特点

- 基于Spring Boot 3.3.12构建
- 使用Thymeleaf作为模板引擎
- 使用Bootstrap 5进行UI美化
- 实现了简单的用户管理功能

## 项目结构
Trae

# Bootstrap在项目中的作用
Bootstrap是一个流行的前端框架，在我们的Spring Boot项目中使用它主要有以下几个目的：

## 1. 提供响应式布局
Bootstrap内置了一套响应式栅格系统，可以让我们的网页在不同设备（手机、平板、电脑）上都能自动调整布局，呈现最佳的显示效果。例如，在我们的用户列表页面中，表格会根据屏幕大小自动调整。

## 2. 美化UI组件
Bootstrap提供了大量预定义的UI组件，如：

- 导航栏（我们项目中顶部的黑色导航条）
- 表格样式（用户列表的表格）
- 卡片组件（首页上的三个功能卡片）
- 按钮样式（各种颜色和大小的按钮）
- 表单控件（添加用户页面的输入框）
这些组件都经过精心设计，美观且易用，使我们不必从零开始编写CSS。

## 3. 统一的设计风格
Bootstrap提供了一套统一的设计语言，使整个应用的UI风格保持一致。例如，我们使用了Bootstrap的：

- 颜色系统（主色、次色、成功色、警告色等）
- 间距系统（margin和padding的统一设置）
- 阴影效果（卡片和导航栏的阴影）
## 4. 简化开发流程
通过使用Bootstrap，我们可以：

- 减少编写CSS的时间
- 专注于业务逻辑而非样式调整
- 利用现成的组件快速构建界面
## 5. 在项目中的具体应用
在我们的项目中，Bootstrap通过WebJars的方式引入（在pom.xml中添加的依赖）：

```
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>bootstrap</artifactId>
    <version>5.3.2</version>
</dependency>

<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>webjars-locator-core</
    artifactId>
</dependency>
```
然后在Thymeleaf模板中通过以下方式引用：

```
<link rel="stylesheet" th:href="@{/
webjars/bootstrap/css/bootstrap.min.css}">
<script th:src="@{/webjars/bootstrap/js/
bootstrap.bundle.min.js}"></script>
```
这样，我们就可以使用Bootstrap的各种CSS类和JavaScript组件来美化我们的页面，使其更加专业和用户友好。

Jinhu Ke

复制

删除

创建readme文件和用户表sql语句，在表中插入6条数据

Trae

模型响应失败，请稍后重试

Jinhu Ke

复制

删除

创建readme文件和用户表sql语句，在表中插入6条数据

Trae

# 创建README文件和用户表SQL语句
根据您的要求，我将为您创建一个README.md文件和用户表的SQL语句，包含6条示例数据。

## README.md 文件
```
# Spring Boot 演示项目

这是一个使用Spring Boot、Thymeleaf和
Bootstrap构建的简单Web应用程序演示项目。

## 项目特点

- 基于Spring Boot 3.3.12构建
- 使用Thymeleaf作为模板引擎
- 使用Bootstrap 5进行UI美化
- 实现了简单的用户管理功能

## 项目结构

```
src/main/java/com/jonas/springdemo
├── SpringdemoApplication.java        # 应用程序入口
├── HomeController.java               # 首页控制器
├── controller
│   └── UserController.java           # 用户管理控制器
├── model
│   └── User.java                     # 用户模型类
└── service
└── UserService.java              # 用户服务类

src/main/resources
├── static                            # 静态资源目录
│   └── css
│       └── main.css                  # 自定义样式
└── templates                         # Thymeleaf模板目录
├── home.html                     # 首页模板
├── layout
│   └── default.html              # 布局模板
└── users
├── form.html                 # 用户表单模板
└── list.html                 # 用户列表模板


## 如何运行

1. 确保已安装JDK 21和Maven
2. 克隆项目到本地
3. 在项目根目录执行：
./mvnw spring-boot:run

4. 访问 http://localhost:8080

## 功能说明

- 首页：展示欢迎信息和功能导航
- 用户列表：查看所有用户信息
- 添加用户：创建新用户

## 数据库配置

项目目前使用内存中的模拟数据，如需连接实际数据库，请在`application.properties`中添加相应配置，并在`pom.xml`中添加数据库驱动依赖。

## 数据库脚本

在`src/main/resources/sql`目录下提供了创建用户表和初始化数据的SQL脚本。
