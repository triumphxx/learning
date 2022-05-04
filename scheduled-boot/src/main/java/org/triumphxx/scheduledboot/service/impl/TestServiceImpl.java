package org.triumphxx.scheduledboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.triumphxx.scheduledboot.file.FileTransferService;
import org.triumphxx.scheduledboot.service.TestService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:triumphxx
 * @Date: 2022/1/17
 * @Time: 13:51
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@Service
@PropertySource(value = "classpath:/ftp.properties")
public class TestServiceImpl implements TestService {

    @Autowired
    FileTransferService fileTransferService;

    @Value("${ftp1.LOCAL_UPLOAD_DIR}")
    private String out;
    @Value("${ftp1.SUCCESS_MOVE_DIR}")
    private String success;
    @Value("${ftp2.LOCAL_UPLOAD_DIR}")
    private String out2;

    static Map<String, String> threadMap = new ConcurrentHashMap<>();

    @Override
    public void upload(ThreadPoolExecutor threadPool) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名称" + Thread.currentThread().getName() + "，TestService 在执行~~~~~~~~~~~~~~~");
                //批处理启动的时候，先判断是那个线程在执行，线程UploadThreadName-1只处理out目录的文件
                //线程UploadThreadName-2只处理out2目录的文件
                //先将线程的名称放到map中
                if (Thread.currentThread().getName().equals("UploadThreadName-1")) {
                    threadMap.put(Thread.currentThread().getName(), out);
                } else {
                    threadMap.put(Thread.currentThread().getName(), out2);
                }
                //开始处理文件
                dealWithFile(threadMap);
                System.out.println("线程名称" + Thread.currentThread().getName() + "，TestService 执行结束~~~~~~~~~~~~~~~");
            }
        });
    }

    private void dealWithFile(Map<String, String> threadMap) {
        if (threadMap != null) {
            fileTransferService.run(threadMap.get(Thread.currentThread().getName()), success);
        }
    }
}
