//package org.triumphxx.secretboot.name;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
///**
// * @author:triumphxx
// * @Date: 2022/1/6
// * @Time: 17:37
// * @微信公众号：北漂码农有话说
// * @网站：https://blog.triumphxx.com.cn
// * @GitHub https://github.com/triumphxx
// * @Desc: 在启动JAR包的时候，指定文件目录和输出目录 进行文件的加减密操作
// *        eg：java -jar secret-boot-1.0.jar --zip.sPath=D:/app/bddy/zip/ --zip.tPath=D:/app/bddy/unzip/
// **/
//@Component
//public class ContextStartup implements ApplicationRunner {
//    @Value("${file.sPath}")
//    private String sourceFilePath = "D:/app/bddy/zip/";
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        File file = new File(sourceFilePath);
//        String[] fileList = file.list();
//        for (String string : fileList) {
//            System.out.println(string);
//        }
//    }
//}
