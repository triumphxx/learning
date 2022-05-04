package org.triumphxx.ioc;

/**
 * @author:triumphxx
 * @Date:2021/5/31
 * @Time:6:40 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 模拟IOC工厂，IOC工厂其实就是工厂模式加反射实现的
 **/
public class IocFactory {

    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
