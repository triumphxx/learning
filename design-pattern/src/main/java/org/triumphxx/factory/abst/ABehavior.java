package org.triumphxx.factory.abst;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:8:53 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class ABehavior implements Behavior {
    @Override
    public void go() {
        System.out.println("我能打游戏");
    }
}
