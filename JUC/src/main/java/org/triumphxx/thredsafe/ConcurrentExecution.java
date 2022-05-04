package org.triumphxx.thredsafe;

import java.util.concurrent.CountDownLatch;

/**
 * @author:triumphxx
 * @Date:2021/4/19
 * @Time:10:17 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 使用CountDownLatch 并发工具 使三个线程同时执行
 **/
public class ConcurrentExecution {


    public static void main(String[] args) throws InterruptedException {
        int size = 3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                try {
                    //子线程在这里配对
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName() + "的线程执行的开始时间" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // 给子线程启动预留一点时间
        Thread.sleep(5000);
        //主线程开始倒计时
        countDownLatch.countDown();
    }
}
