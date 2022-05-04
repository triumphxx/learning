package org.triumphxx.singleton;

/**
 * @author:triumphxx
 * @Date:2021/5/23
 * @Time:8:30 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 最简单的单例，懒汉式模式--》线程安全
 **/
public class Singleton01 {

    private static final Singleton01 INSTANCE = new Singleton01();


    private Singleton01() {

    }

    public static Singleton01 getINSTANCE() {
        return INSTANCE;
    }


}
