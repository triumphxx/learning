package org.triumphxx.thredsafe;

import java.util.concurrent.locks.LockSupport;

/**
 * @author:triumphxx
 * @Date:2021/5/24
 * @Time:1:50 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 将一个字符串的字符 俩个线程交替输出
 **/
public class LockSupportTest {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] num = "12345678".toCharArray();
        char[] zm = "ABCDEFGH".toCharArray();

        t1 = new Thread(() -> {
            for (char c : num) {
                System.out.println(c);
                //叫醒t2
                LockSupport.unpark(t2);
                //自己阻塞
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : zm) {
                //自己阻塞
                LockSupport.park();
                System.out.println(c);
                //叫醒t1
                LockSupport.unpark(t1);

            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
