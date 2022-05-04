package org.triumphxx.thredsafe;

import java.util.concurrent.Semaphore;

/**
 * @author:triumphxx
 * @Date:2021/4/19
 * @Time:10:54 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 使用并发工具 Semaphore 实现线程有序交错执行
 **/
public class Interleaving {

    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(1);
    private static Semaphore s3 = new Semaphore(1);

    public static void main(String[] args) {

        try {
            /**
             * 首先将s1和s2的信号量暂用,让s3先获取信号
             * s3执行完成后，释放s1的信号量，s1执行完成
             * 后释放s2的信号量
             */
            s1.acquire();
            s2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            while (true) {
                try {
                    //获取s1的信号
                    s1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("❤我❤");
                //释放s2的信号
                s2.release();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    //获取s2的信号
                    s2.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("爱你");
                System.out.println();
                //释放s3的信号
                s3.release();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    //获取s3的信号
                    s3.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("媳妇");
                //释放s1的信号
                s1.release();
            }
        }).start();
    }
}
