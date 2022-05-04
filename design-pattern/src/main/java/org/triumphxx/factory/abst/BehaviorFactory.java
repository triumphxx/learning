package org.triumphxx.factory.abst;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:8:56 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 行为工厂
 **/
public class BehaviorFactory extends AbstractFactory {
    @Override
    Product makeProduct(String flag) {
        return null;
    }

    @Override
    Behavior toBehavior(String flag) {
        if ("A".equals(flag)) {
            return new ABehavior();
        }
        if ("B".equals(flag)) {
            return new BBehavior();
        }
        return null;
    }
}
