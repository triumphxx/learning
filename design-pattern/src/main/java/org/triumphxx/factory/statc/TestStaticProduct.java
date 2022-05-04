package org.triumphxx.factory.statc;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:8:36 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试静态工厂, 就是讲所有逇类先准备好
 **/
public class TestStaticProduct {
    public static void main(String[] args) {
        Product product = StaticFactory.makeProduct("A");
        product.show();
    }
}
