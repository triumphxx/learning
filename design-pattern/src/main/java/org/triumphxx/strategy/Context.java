package org.triumphxx.strategy;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:10:45 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 策略执行器
 **/
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int doCal(int num1, int num2) {
        return strategy.doCal(num1, num2);
    }
}
