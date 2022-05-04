package org.triumphxx.ioc;

/**
 * @author:triumphxx
 * @Date:2021/5/31
 * @Time:6:42 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试IOC反射工厂
 **/
public class IocClient {

    public static void main(String[] a) {
        Fruit f = IocFactory.getInstance("org.triumphxx.ioc.Apple");
        if (f != null) {
            f.eat();
        }
    }
}
