package org.triumphxx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author:triumphxx
 * @Date:2021/8/7
 * @Time:9:50 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 使用volatile关键字使线程之间变量的操作实现可见性
 **/
public class WithoutVolatile {
    private /*volatile*/ List list = new ArrayList();
//    private List list = Collections.synchronizedList(new ArrayList<>());
    /**
     * 添加元素的方法
     * @param object
     */
    private void add (Object object){
        list.add(object);
    }

    /**
     * 获取元素个数的方法
     * @return
     */
    private int size (){
        return list.size();
    }

    public static void main(String[] args) {
        WithoutVolatile wv = new WithoutVolatile();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                wv.add(new Object());
                System.out.println("第" + i +" 个元素进入容器");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                if (wv.size() == 5){
                    System.out.println("元素个数达到预期"+ wv.size());
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        },"t2").start();

    }
}
