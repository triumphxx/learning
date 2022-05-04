package org.triumphxx.thredsafe;

/**
 * @author:triumphxx
 * @Date:2021/4/19
 * @Time:10:37 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 使用关键字volatile 定义信号量实现  实现线程依次执行
 **/
public class Sequentially {
    /**
     * volatile 修饰的变量具有线程可见性，
     * 也就是说变量的改变，线程是可以感知的
     */
    static volatile int ticket = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (1 == ticket) {
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("a" + i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket = 2;
                    return;
                }
            }
        });


        Thread t2 = new Thread(() -> {
            while (true) {
                if (2 == ticket) {
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("b" + i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket = 3;
                    return;
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                if (3 == ticket) {
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("c" + i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket = 1;
                    return;
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
