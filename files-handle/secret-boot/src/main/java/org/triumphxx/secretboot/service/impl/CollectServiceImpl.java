package org.triumphxx.secretboot.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.triumphxx.secretboot.service.CollectService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author:triumphxx
 * @Date: 2022/1/17
 * @Time: 10:56
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@Service
public class CollectServiceImpl implements CollectService {
    @Value("${file.sPath}")
    private String sourceFilePath;
    @Value("${file.tPath}")
    private String targetFilePath;

    @Override
    public void collect() {
        String[] dateArry = {};
        String[] contNoArry = {};
        System.out.println("需要处理的保单数量为：" + contNoArry.length);
        for (int k = 0; k < dateArry.length; k++) {
            for (int j = 0; j < contNoArry.length; j++) {
                String path = dateArry[k] + "/" + contNoArry[j] + "/";
                File file = new File(sourceFilePath + path);
                if (file == null || "".equals(file)) {
                    System.out.println("该文件夹不存在：" + sourceFilePath + path);
                    continue;
                }
                File[] fileList = file.listFiles();
                if (fileList == null || "".equals(fileList)) {
                    System.out.println("该文件夹下没有文件存在：" + sourceFilePath + path);
                    continue;
                }
                for (int i = 0; i < fileList.length; i++) {
                    //判断是否为文件
                    if (fileList[i].isFile()) {
                        try {
                            collect(sourceFilePath + path + fileList[i].getName(), targetFilePath + fileList[i].getName());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
        System.out.println("保单数据全部汇总完成~~~~~~~~~~~~~~~~~~~~~");
    }

    /*
     * 汇总文件
     */

    public static void collect(String sourceFilePath, String targetFilePath) throws IOException {
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
