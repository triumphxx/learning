package org.triumphxx.lock;

/**
 * @author:triumphxx
 * @Date:2021/5/23
 * @Time:8:02 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: volatile 保证线程可见性
 **/
public class VolatileDemo {

    volatile boolean running = true;

    public void m() {
        System.out.println("m方法开始运行");
        while (running) {
            //模拟服务器操作
        }
        System.out.println("m方法结束运行");
    }


    public static void main(String[] args) {

        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(volatileDemo::m, "volatileDemo").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        volatileDemo.running = false;
    }
}
