package org.triumphxx.scheduledboot.config;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:triumphxx
 * @Date: 2021/12/7
 * @Time: 10:26
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 线程工厂，将线程进行分组，给每一个线程起一个名称
 **/
public class ThreadPoolFactory implements ThreadFactory {
    /**
     * 线程组
     */
    protected ThreadGroup group;
    /**
     * 线程编号
     */
    protected final AtomicInteger threadNumber = new AtomicInteger(1);
    /**
     * 线程名称前缀
     */
    protected String namePrefix;

    /**
     * 构造器
     */
    public ThreadPoolFactory() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = "UploadThreadName-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        return t;
    }
}
