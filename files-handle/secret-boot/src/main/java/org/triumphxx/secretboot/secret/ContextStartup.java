package org.triumphxx.secretboot.secret;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author:triumphxx
 * @Date: 2022/1/6
 * @Time: 17:37
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 在启动JAR包的时候，指定文件目录和输出目录 进行文件的加减密操作
 * eg：java -jar secret-boot-1.0.jar --zip.sPath=D:/app/bddy/zip/ --zip.tPath=D:/app/bddy/unzip/
 **/
@Component
public class ContextStartup implements ApplicationRunner {
    @Value("${file.sPath}")
    private String sourceFilePath = "D:/app/bddy/zip/";
    @Value("${file.tPath}")
    private String targetFilePath = "D:/app/bddy/unzip/";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        File file = new File(sourceFilePath);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            //判断是否为文件
            if (fileList[i].isFile()) {
                try {
                    security(sourceFilePath + fileList[i].getName(), targetFilePath + fileList[i].getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 加密 和 解密操作
     * sourceFilePath: 输入文件路径+文件名
     * targetFilePath: 输出文件路径+文件名*/

    public static void security(String sourceFilePath, String targetFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath.substring(0, targetFilePath.lastIndexOf("/")));
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            outputStream = new FileOutputStream(new File(targetFilePath));
            while ((len = inputStream.read(buffer)) > 0) {
                byte[] outputBuffer = new byte[len];
                //分别对每个字节进行异或操作
                for (int i = 0; i < len; i++) {
                    byte b = buffer[i];
                    b = (byte) (b ^ 25);
                    outputBuffer[i] = b;
                }
                outputStream.write(outputBuffer, 0, len);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
