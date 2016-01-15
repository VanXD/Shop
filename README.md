做个小笔记吧：
    1.证书导入JDK一定要确认目录：%JAVE_HOME%\jre\lib\security下。参考资料：http://stackoverflow.com/questions/9619030/resolving-javax-net-ssl-sslhandshakeexception-sun-security-validator-validatore
    2.ssl加密的服务端口号(本项目中的8443, 9443)：因为用了2个tomcat所以分成了2个ssl端口，主要还是tomcat中 conf/server.xml配置


参考资料：
    1.http://jinnianshilongnian.iteye.com/blog/2018398
    2.http://itindex.net/detail/51110-cas-4.0-%E7%99%BB%E5%BD%95 及该链接里的参考链接