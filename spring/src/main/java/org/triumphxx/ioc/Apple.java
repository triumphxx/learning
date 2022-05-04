package org.triumphxx.ioc;

/**
 * @author:triumphxx
 * @Date:2021/5/31
 * @Time:6:38 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 苹果实现
 **/
public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("Apple");
    }
}
