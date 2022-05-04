package org.triumphxx.lock;

/**
 * @author:triumphxx
 * @Date:2021/5/22
 * @Time:10:20 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: synchronized 关键词的使用，其可以锁任何对对象
 **/
public class SyncDemo implements Runnable {
    private volatile static int count = 1000;

    @Override
    public void run() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count 的值为 ：" + count);
        }
    }

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(syncDemo, "线程" + i).start();
        }
    }
}
