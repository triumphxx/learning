package org.triumphxx.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triumphxx.config.QueueConfig;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author:triumphxx
 * @Date: 2021/12/27
 * @Time: 16:55
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 对列管理器 用于数据排队
 **/
public class QueueManager {
    public static final Logger LOGGER = LogManager.getLogger();
    /**
     * 数据队列：把数据封装线程封装的数据（一个单元）放到此队列中
     */
    private static final LinkedBlockingQueue workQueue = new LinkedBlockingQueue(QueueConfig.dataQueueSize);

    public volatile static long queuesize = 0;

    /**
     * 往数据队列 中加入元素
     */
    public void putWorkQueue(Map map) {
        boolean flag = true;
        try {
            //将指定元素插入到此队列的尾部，如有必要，则等待空间变得可用。
            workQueue.put(map);
            queuesize++;
        } catch (Exception e) {
            LOGGER.error("往数据队列里放数据时异常！", e);
        }
    }


    /**
     * 返回数据队列
     */
    public static LinkedBlockingQueue getWorkQueue() {
        return workQueue;
    }

    /**
     * 返回数据队列
     */
    public static Object take() {
        Object obj = null;
        try {
            long start1 = System.currentTimeMillis();
            synchronized (workQueue) {
                obj = workQueue.take();
            }
            LOGGER.info("take线程用的时间" + (System.currentTimeMillis() - start1));
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        }
        queuesize--;

        return obj;
    }

    /**
     * 返回数据队列的当前长度，可用来判断队列的状态 --是否为空
     */
    public static long getWorkQueueSize() {
        return workQueue.size();
    }
}
