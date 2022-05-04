package org.triumphxx.filetransfer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author:triumphxx
 * @Date: 2022/1/19
 * @Time: 18:55
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@Component
public class FileTransferService implements ApplicationRunner {
    @Value("${file.sPath}")
    String sPath = "";
    @Value("${file.tPath}")
    String tPath = "";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] fileList = getFileList(sPath);
        System.out.println("获取到的文件数量：" + fileList.length);
        int count = 0;
        for (String file : fileList) {
            //目标OUT目录
            String outPath = tPath;
            if (!(new File(outPath)).exists()) {
                (new File(outPath)).mkdirs();
            }
            // 转移文件并将原文件删除
            copyFile(sPath + file, outPath + file);
            count++;
//            if (count==100){
//                if(fileList.length == (count  + getFileList(sPath).length) ){
//                    if (getFileList(sPath).length<=100){
//                        count=0;
//                        run(args);
//                    }else {
//                        Thread.sleep(20 * 60 *1000);
//                    }
//                }
//            }
        }
    }


    /**
     * 获取文件夹所有文件
     *
     * @return 该文件夹下所有文件数组
     */
    public String[] getFileList(String path) {
        try {
            File file = new File(path);
            return file.list();
        } catch (Exception e) {
            System.err.println("文件获取异常");
            return null;
        }
    }

    public static void copyFile(String oldPath, String newPath) {
        try {
            File oldFile = new File(oldPath);
            File file = new File(newPath);
            FileInputStream in = new FileInputStream(oldFile);
            FileOutputStream out = new FileOutputStream(file);
            byte[] buffer = new byte[2097152];
            int readByte = 0;
            while ((readByte = in.read(buffer)) != -1) {
                out.write(buffer, 0, readByte);
            }
            in.close();
            out.close();
            boolean deleteResult = oldFile.delete();
            System.out.println("文件删除结果：" + deleteResult);
        } catch (Exception e) {
            System.err.println("复制老路径内的文件到新路径发生异常");
        }
    }
}
