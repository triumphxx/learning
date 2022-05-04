package org.triumphxx.thredsafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:triumphxx
 * @Date: 2021/11/2
 * @Time: 10:16
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class ReentrantLockTest {
    public static void main(String[] args) {
        Add add = new Add();
        for (int i = 0; i < 1000; i++) {
            new Thread(add).start();
        }
    }

    static class Add implements Runnable {
        volatile static int count = 0;

        @Override
        public void run() {
            ReentrantLock lock = new ReentrantLock();
            lock.lock();
            try {
                count++;
                System.out.print("count的值" + count);
            } finally {
                lock.unlock();
            }
        }
    }
}
