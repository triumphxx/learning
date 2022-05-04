package org.triumphxx.singleton;

/**
 * @author:triumphxx
 * @Date:2021/5/23
 * @Time:8:30 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 双重检查
 **/
public class Singleton02 {

    private static Singleton02 INSTANCE;


    private Singleton02() {

    }

    public static Singleton02 getINSTANCE() {

        if (INSTANCE == null) {
            synchronized (Singleton02.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton02();
                }
            }
        }
        return INSTANCE;
    }


}
