package org.triumphxx.scheduledboot.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.triumphxx.scheduledboot.config.ThreadPoolManager;
import org.triumphxx.scheduledboot.service.TestService;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:triumphxx
 * @Date: 2022/1/17
 * @Time: 13:47
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 多线程文件上传
 **/
@Component
@PropertySource(value = "classpath:/cron.properties")
@EnableAsync
public class TestScheduledJob {
    @Autowired
    private TestService testService;
    private static ThreadPoolExecutor threadPool =
            ThreadPoolManager.getThreadPool();

    @Scheduled(cron = "${upcron}")
    @Async
    public void ftpUploadTask() throws InterruptedException {
        testService.upload(threadPool);
    }
}
