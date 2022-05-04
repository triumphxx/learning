package org.triumphxx.singleton;

/**
 * @author:triumphxx
 * @Date:2021/5/23
 * @Time:8:43 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 最完美的解决方案，静态内部类，在JVM层面保证实例只有一个
 * 在加载该类的时候不会加载内部类
 **/
public class Singleton03 {

    private Singleton03() {
    }

    private static class Singleton03Holder {
        private final static Singleton03 INSTANCE = new Singleton03();
    }

    public Singleton03 getINSTANCE() {
        return Singleton03Holder.INSTANCE;
    }
}
