package org.triumphxx.thredsafe;

import java.util.concurrent.TimeUnit;

/**
 * @author:triumphxx
 * @Date:2021/5/24
 * @Time:10:10 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: ThreadLocal 线程隔离，每个线程只能操作自己的东西
 **/
public class ThreadLocalTest {

    static ThreadLocal<Person> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + threadLocal.get());
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person());
        }).start();

    }


    static class Person {
        String name = "zhangsan";
    }


}


