package org.triumphxx.thredsafe;

/**
 * @author:triumphxx
 * @Date:2021/5/9
 * @Time:9:47 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class ThreadConn {

    static volatile int FLAG = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (1 == FLAG) {
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("a" + i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    FLAG = 2;
                    return;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                if (2 == FLAG) {
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("b" + i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    FLAG = 3;
                    return;
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                if (3 == FLAG) {
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("c" + i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    FLAG = 1;
                    return;
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
