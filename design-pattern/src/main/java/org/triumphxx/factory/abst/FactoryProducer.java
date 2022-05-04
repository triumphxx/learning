package org.triumphxx.factory.abst;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:9:05 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 工厂生成器
 **/
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("PRODUCT")) {
            return new ProductFactory();
        } else if (choice.equalsIgnoreCase("BEHAVIOR")) {
            return new BehaviorFactory();
        }
        return null;
    }
}
