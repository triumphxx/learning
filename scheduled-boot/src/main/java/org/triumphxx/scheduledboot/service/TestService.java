package org.triumphxx.scheduledboot.service;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:triumphxx
 * @Date: 2022/1/17
 * @Time: 13:50
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public interface TestService {
    void upload(ThreadPoolExecutor threadPool) throws InterruptedException;
}
