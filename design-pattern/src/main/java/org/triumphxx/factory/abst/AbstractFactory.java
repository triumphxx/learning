package org.triumphxx.factory.abst;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:8:40 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 抽象的工厂类
 **/
public abstract class AbstractFactory {
    //产生具体的产品
    abstract Product makeProduct(String flag);

    //产品的行为
    abstract Behavior toBehavior(String flag);
}
