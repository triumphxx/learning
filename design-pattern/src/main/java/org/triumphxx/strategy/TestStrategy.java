package org.triumphxx.strategy;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:10:47 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试策略模式
 **/
public class TestStrategy {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println(context.doCal(10, 5));

        context = new Context(new SubtractStrategy());
        System.out.println(context.doCal(10, 5));

        context = new Context(new MultiplyStrategy());
        System.out.println(context.doCal(10, 5));

    }

}
