package org.triumphxx.strategy;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:10:40 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 加法策略
 **/
public class AddStrategy implements Strategy {
    @Override
    public int doCal(int num1, int num2) {
        return num1 + num2;
    }
}
