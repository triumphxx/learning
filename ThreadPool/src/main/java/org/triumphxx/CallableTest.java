package org.triumphxx;

import org.triumphxx.threadpool.ThreadPoolManager;

import java.util.concurrent.*;

/**
 * @author:triumphxx
 * @Date:2021/5/24
 * @Time:2:33 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: Callable 执行的结果保存在Future中
 **/
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                return "hello Callable";
            }
        };
        //创建线程池
        ThreadPoolExecutor threadPool = ThreadPoolManager.getThreadPool();
        //异步执行任务
        Future<String> future = threadPool.submit(callable);
        //阻塞
        System.out.println(future.get());
        threadPool.shutdown();
    }
}
