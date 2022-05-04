package org.triumphxx.factory.abst;


/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:8:46 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 生产产品A的工厂
 **/
public class ProductFactory extends AbstractFactory {

    @Override
    Product makeProduct(String flag) {
        if ("A".equals(flag)) {
            return new ProductA();
        }
        if ("B".equals(flag)) {
            return new ProductB();
        }
        return null;
    }

    @Override
    Behavior toBehavior(String flag) {
        return null;
    }
}
