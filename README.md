#   做个小笔记吧：
    1.  证书导入JDK一定要确认目录：%JAVE_HOME%\jre\lib\security下。参考资料：http://stackoverflow.com/questions/9619030/resolving-javax-net-ssl-sslhandshakeexception-sun-security-validator-validatore
    2.  ssl加密的服务端口号(本项目中的8443, 9443)：因为用了2个tomcat所以分成了2个ssl端口，主要还是tomcat中 conf/server.xml配置
    3.  客户端的修改：ssl端口号(8443,9443这种)，spring-shiro-web.xml的客户端路径及的端口号，POM文件artifactId直接替换统一就好
    4.  因为LoginCas 会报认证头的错误 所以运行的时候使用了这个命令：clean install -Dlicense.skip=true tomcat7:run
    5.  事务管理器(transactionManager)跟你底层持久化的方式有关，org.springframework.jdbc.datasource.DataSourceTransactionManager，这就是个普通的事务管理器，而JPA需要用org.springframework.orm.jpa.JpaTransactionManager 这一个

#   Spring DATA JPA Repository save方法返回成功且不报异常，但数据库里没有保存
    其实就是事务没有提交成功，根据参考资料3终于找到正确的事务管理器。
    **事务管理器[^transactionManager]**跟你底层持久化的方式有关，org.springframework.jdbc.datasource.DataSourceTransactionManager，这就是个普通的事务管理器，而JPA需要用org.springframework.orm.jpa.JpaTransactionManager 这一个
    

#   参考资料：
    1.  http://jinnianshilongnian.iteye.com/blog/2018398
    2.  http://itindex.net/detail/51110-cas-4.0-%E7%99%BB%E5%BD%95 及该链接里的参考链接
    3.  http://sishuok.com/forum/posts/list/7000.html 深入浅出学Spring Data JPA