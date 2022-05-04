//package org.triumphxx.secretboot.secret;
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
//import java.util.List;
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
//public class ContextStartupTwo implements ApplicationRunner {
//    @Value("${file.sPath}")
//    private String sourceFilePath ="D:/app/bddy/zip/";
//    @Value("${file.tPath}")
//    private String targetFilePath ="D:/app/bddy/unzip/";
//    @Value("${file.date}")
//    private String[] dateFile;
//    @Value("${file.no}")
//    private String[] noFile;
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        String[] dateArry = dateFile;
//        String[] contNoArry = noFile;
//        System.out.println("需要处理的保单数量为："+contNoArry.length);
//        for (int k = 0; k < dateArry.length; k++) {
//            for (int j = 0 ;j<contNoArry.length;j++){
//                String path = dateArry[k]+"/"+ contNoArry[j]+"/";
//                File file = new File(sourceFilePath+path);
//                if (file==null || "".equals(file)){
//                    System.out.println("该文件夹不存在："+sourceFilePath+path);
//                    continue;
//                }
//                File[] fileList = file.listFiles();
//                if (fileList==null || "".equals(fileList)){
//                    System.out.println("该文件夹下没有文件存在："+sourceFilePath+path);
//                    continue;
//                }
//                for (int i = 0; i < fileList.length; i++) {
//                    //判断是否为文件
//                    if (fileList[i].isFile()) {
//                        try {
//                            security(sourceFilePath+path + fileList[i].getName(),
//                                    targetFilePath + fileList[i].getName());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//
//        }
//        System.out.println("保单数据全部汇总完成~~~~~~~~~~~~~~~~~~~~~");
//    }
//
//    /*
//     * 汇总文件
//     */
//
//    public static void security(String sourceFilePath, String targetFilePath) throws IOException {
//        try {
//            File oldFile = new File(sourceFilePath);
//            File file = new File(targetFilePath);
//            FileInputStream in = new FileInputStream(oldFile);
//            FileOutputStream out = new FileOutputStream(file);
//            byte[] buffer = new byte[2097152];
//            int readByte = 0;
//            while ((readByte = in.read(buffer)) != -1) {
//                out.write(buffer, 0, readByte);
//            }
//            in.close();
//            out.close();
//        } catch (Exception e) {
//            System.out.println("出错了！~！！！！！！！");
//        }
//    }
//}
