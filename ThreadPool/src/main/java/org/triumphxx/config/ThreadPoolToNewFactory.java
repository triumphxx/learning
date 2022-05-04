package org.triumphxx.config;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:triumphxx
 * @Date: 2022/1/6
 * @Time: 9:22
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class ThreadPoolToNewFactory implements ThreadFactory {
    /**
     * 线程池编号
     */
    protected static final AtomicInteger poolNumber = new AtomicInteger(1);
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
    public ThreadPoolToNewFactory() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = "new_pool-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        return thread;
    }
}
