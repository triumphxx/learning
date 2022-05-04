package org.triumphxx.test;

import org.triumphxx.config.ThreadPoolToNewFactory;
import org.triumphxx.threadpool.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:triumphxx
 * @Date:2021/5/24
 * @Time:2:33 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: Callable 执行的结果保存在Future中
 **/
public class FactoryTest extends Thread {
    public static void main(String[] args) throws ExecutionException {
        //创建线程工厂类-可以自己定义线程的名称
        ThreadPoolToNewFactory threadPoolToNewFactory = new ThreadPoolToNewFactory();
        List<String> list = new ArrayList<>();
        FactoryTool test = new FactoryTool(list);
        //创建线程池
        ThreadPoolExecutor threadPool = ThreadPoolManager.getThreadPool(threadPoolToNewFactory);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(test);
        }
        threadPool.shutdown();
    }


}
