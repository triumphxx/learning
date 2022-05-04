package org.triumphxx.factory.abst;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:8:32 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 定义产品A
 **/
public class ProductA extends Product {

    @Override
    void getName() {
        System.out.println("我是游戏机");
    }
}
