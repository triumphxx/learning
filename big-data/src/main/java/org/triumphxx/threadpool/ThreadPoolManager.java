package org.triumphxx.threadpool;

import org.triumphxx.config.ThreadPoolConfig;
import org.triumphxx.config.ThreadPoolFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:triumphxx
 * @Date: 2021/12/7
 * @Time: 10:07
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 自己定义线程池
 **/
public class ThreadPoolManager {
    private static ThreadPoolExecutor executor = null;

    /**
     * 单例
     */
    private ThreadPoolManager() {
    }

    public static ThreadPoolExecutor getThreadPool() {
        //懒加载
        if (executor == null) {
            executor = new ThreadPoolExecutor(
                    //核心线程数
                    ThreadPoolConfig.corePoolSize,
                    // 最大线程数据
                    ThreadPoolConfig.maximumPoolSize,
                    //线程存活时间
                    ThreadPoolConfig.keepAliveTime,
                    //线程存活时间单位
                    ThreadPoolConfig.timeUnit,
                    //线程队列
                    new LinkedBlockingQueue<>(ThreadPoolConfig.threadQueueSize),
                    //线程工厂
                    new ThreadPoolFactory(),
                    //达到线程边界和队列容量 线程阻塞时 执行的策略
                    new ThreadPoolExecutor.DiscardOldestPolicy()
            );
        }
        return executor;
    }

    /**
     * 关闭线程池
     */
    public static void closeThreadPool() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
            executor = null;
        }
    }
}
