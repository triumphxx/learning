package org.triumphxx;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author:triumphxx
 * @Date:2021/5/24
 * @Time:2:40 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: FutureTask 即使一个人也是一个容器，接收自己执行任务的返回结果
 **/
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            return 10000;
        });

        new Thread(task).start();

        System.out.println(task.get());
    }

}
