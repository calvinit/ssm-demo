# ssm-demo

#### 介绍
SSM框架搭建示例Demo

#### 使用说明

1. 使用 docs/ssm.sql 脚本创建示例数据库和表，初始化测试数据；
2. src/main/resources/properties/jdbc.properties 文件修改数据库连接信息；
3. src/test/java/com.example.ssm.AutoCodeGenerator 类 generate() 方法中修改数据库连接信息；
4. 配置 Tomcat 部署项目并启动。