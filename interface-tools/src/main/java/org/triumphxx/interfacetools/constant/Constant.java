package org.triumphxx.interfacetools.constant;

/**
 * @author:triumphxx
 * @Date:2020/8/29
 * @Time:10:56 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 常量类
 **/
public class Constant {

    public static final String TOKEN_NAME = "token";

    public static class ExceptionCode{
        public static final int EXCEPTION_CODE= 404;
    }


    public static class ExceptionMessage{
        public static final String  EXCEPTION_TOKEN_MESSAGE ="请传入TOKEN";
        public static final String  EXCEPTION_REDIS_TOKEN_MESSAGE="TOKEN已失效，请重新获取";
        public static final String  EXCEPTION_REDIS_TOKEN_EXPIRE_MESSAGE="由于您长时间未操作，TOKEN已过期，请重新获取";
        public static final String  EXCEPTION_BRUSH="您的请求超出了，允许访问的次数、请稍后重试！！";
        public static final String  EXCEPTION_LOGIN_MESSAGE ="请先进行系统登录！！！";
    }

    public static class Redis{
        public static final String  TOKEN_PREFIX ="TR";
    }
}
