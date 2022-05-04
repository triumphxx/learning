package org.triumphxx.dispose;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triumphxx.calculate.BusinessTask;
import org.triumphxx.config.PubConfig;
import org.triumphxx.queue.QueueManager;
import org.triumphxx.threadpool.ThreadPoolManager;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:triumphxx
 * @Date: 2021/12/27
 * @Time: 17:33
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class DealWithData implements Runnable {
    public static final Logger LOGGER = LogManager.getLogger();
    /**
     * 接受参数的容器
     */
    Map paramMap = null;

    public DealWithData(Map paramMap) {
        this.paramMap = paramMap;
    }

    @Override
    public void run() {
        // 多线程去插入数据
        ThreadPoolExecutor executor = ThreadPoolManager.getThreadPool();
        takeData(executor);
    }

    private void takeData(ThreadPoolExecutor executor) {
        PubConfig.DATAALLOT_FG = true;
        try {
            LinkedBlockingQueue TishuQueue = QueueManager.getWorkQueue();
            // 线程池的任务队列
            BlockingQueue mQueue = executor.getQueue();
            // 记录推送给线程池的次数
            int count = 0;
            while (true) {
                if (!PubConfig.DATAALLOT_FG) {
                    break;
                }
                if (mQueue.remainingCapacity() > 100) {
                    // 要处理的数据，是一个XML
                    Map map = (Map) TishuQueue.poll();
                    if (map != null) {
                        executor.execute(new BusinessTask(map));
                        count++;
                        if (count > 0 && count % 1000 == 0) {
                            LOGGER.info("已推送线程池的次数={}", count);
                        }
                    }
                } else {
                    Thread.sleep(1000);
                    LOGGER.trace("任务队列已满，请休息1S钟！");
                }
            }
            LOGGER.info("已推送线程池的次数={}", count);
            PubConfig.DATAALLOT_FG = true;
        } catch (Throwable e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
