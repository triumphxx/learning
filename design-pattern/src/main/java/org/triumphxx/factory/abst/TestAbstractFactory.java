package org.triumphxx.factory.abst;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:8:48 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试抽象工厂
 **/
public class TestAbstractFactory {

    public static void main(String[] args) {
        //获取产品的工厂
        AbstractFactory productFactoryA = FactoryProducer.getFactory("product");
        Product a = productFactoryA.makeProduct("A");
        a.getName();
        //获取产品行为的工厂
        AbstractFactory behaviorFactoryA = FactoryProducer.getFactory("behavior");
        Behavior behavior = behaviorFactoryA.toBehavior("A");
        behavior.go();


        //获取产品的工厂
        AbstractFactory productFactoryB = FactoryProducer.getFactory("product");
        Product b = productFactoryB.makeProduct("B");
        b.getName();
        //获取产品行为的工厂
        AbstractFactory behaviorFactoryB = FactoryProducer.getFactory("behavior");
        Behavior behaviorn = behaviorFactoryB.toBehavior("B");
        behaviorn.go();

    }
}
