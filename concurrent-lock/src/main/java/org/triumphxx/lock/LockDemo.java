package org.triumphxx.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:triumphxx
 * @Date:2021/4/18
 * @Time:8:44 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 使用AQS 实现加锁的操作
 **/
public class LockDemo {

    private static ReentrantLock lock = new ReentrantLock();

    /**
     * 开启俩个线程，第一个下次先加锁，虽然先启动的是第二个线程，但是由于
     * 第一个线程加锁的原因，第一个线程先执行完成
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("t1线程开始执行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("t1线程结束");
        });


        Thread t2 = new Thread(() -> {
            System.out.println("t2线程开始执行");
            //判断是否还在加锁
            while (lock.isLocked()) {

            }
            System.out.println("t2线程结束");
        });

        t2.start();
        t1.start();
    }
}
