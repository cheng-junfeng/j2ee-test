# j2ee-test
- 简单servlet 查询mysql数据库，进行账号的验证
- 重新捡起一下j2ee的实现

# MyEclipse Pro 版本： 创建Web Service Project
- src/ 对Servlet 的实现，doPost 中完整校验
- libs/  WebRoot/WEB-INF/lib  中注意添加mysql-connector-java-5.1.36-bin.jar
- WebRoot/WEB-INF/web.xml     配置对应的url
- 只创建servlet, 暂不管jsp

# Tomcat 7.0: 服务器
- conf/server.xml 基本配置
- webapps/test        具体服务
- 通过http://localhost:8080/test  访问

# MySql 5.7: 数据库
- net stop mysql57  停止服务
- mysqld --skip-grant-tables   跳过认证
- mysqladmin -u root flush-privileges password "123456"  设置新密码
- C:\Program Files\MySQL\MySQL Server 5.7\my.ini  出现找不到datab时，修改此文件                
- datadir="C:\ProgramData\MySQL\MySQL Server 5.5\data\"   改为自己的目录




