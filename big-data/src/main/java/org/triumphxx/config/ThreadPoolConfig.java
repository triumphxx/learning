package org.triumphxx.config;

import java.util.concurrent.TimeUnit;

/**
 * @author:triumphxx
 * @Date: 2021/12/7
 * @Time: 10:12
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 线程池相关参数配置
 **/
public class ThreadPoolConfig {
    /**
     * 核心线程数
     */
    public static int corePoolSize = 20;
    /**
     * 计算线程最大线程数
     */
    public static int maximumPoolSize = 20;
    /**
     * 线程最大存活时间
     */
    public final static int keepAliveTime = 10;
    /**
     * 程最大存活时间单位
     */
    public final static TimeUnit timeUnit = TimeUnit.SECONDS;
    /**
     * 线程队列深度
     */
    public final static int threadQueueSize = 1000;
}
