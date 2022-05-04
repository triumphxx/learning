package org.triumphxx.calculate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triumphxx.config.PubConfig;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author:triumphxx
 * @Date: 2021/12/27
 * @Time: 17:46
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class BusinessTask implements Runnable {
    public static final Logger LOGGER = LogManager.getLogger();
    /**
     * 处理业务数据
     */
    private Map map = null;
    private ArrayList<String> tableList = null;

    @Override
    public void run() {
        // 添加正在执行任务的线程
        synchronized (PubConfig.getExecTaskList()) {
            PubConfig.getExecTaskList().add(Thread.currentThread().getName());
        }
        try {
            // 判断目前的任务线程和表的关系是否对应
            if (!PubConfig.getTableMap().containsKey(Thread.currentThread().getName())) {
                //将线程和该线程要操作的表对应起来
                synchronized (PubConfig.getMTableNameQueue()) {
                    // 每次进行表操作的时候，将线程需要操作的表回去出来，
                    // 前提是每次执行的时候需要重新创建线程池。
                    tableList = PubConfig.getMTableNameQueue().poll();
                    map.put("TableList", tableList);
                    //线程和表的对应关系建立起来了
                    PubConfig.getTableMap().put(Thread.currentThread().getName(), tableList);
                }
            } else {
                tableList = PubConfig.getTableMap().get(Thread.currentThread().getName());
                map.put("TableList", tableList);
            }
        } catch (Throwable e) {
            LOGGER.error("任务分配异常", e);
        }
        //执行业务逻辑代码

        // 任务执行完毕，移除正在执行任务的线程
        synchronized (PubConfig.getExecTaskList()) {
            if (PubConfig.getExecTaskList().contains(Thread.currentThread().getName())) {
                PubConfig.getExecTaskList().remove(Thread.currentThread().getName());
            }
        }
    }

    public BusinessTask(Map pMap) {
        super();
        this.map = pMap;
    }
}
