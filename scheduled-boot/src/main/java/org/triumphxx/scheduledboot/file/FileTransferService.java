package org.triumphxx.scheduledboot.file;

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
public class FileTransferService {

    public void run(String outPath, String successPath) {
        System.out.println("当前线程：" + Thread.currentThread().getName() + ",正在操作的目录为：" + outPath);
        String[] fileList = getFileList(outPath);
        System.out.println("当前线程：" + Thread.currentThread().getName() + "开始处理上传任务，获取到的文件数量：" + fileList.length);
        int count = 0;
        for (String file : fileList) {
            //目标OUT目录
            if (!(new File(outPath)).exists()) {
                (new File(outPath)).mkdirs();
            }
            //模拟上传文件
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "，开始上传文件，文件名称为:" + file);
            try {
                System.out.println("上传文件中。。。。。");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程名称为：" + Thread.currentThread().getName() + ",文件上传结束，文件名称为:" + file);
            // 转移文件并将原文件删除
            copyFile(outPath + file, successPath + file);
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
            System.out.println("线程为:" + Thread.currentThread().getName() + "开始删除文件，文件删除结果：" + deleteResult);
        } catch (Exception e) {
            System.err.println("复制老路径内的文件到新路径发生异常");
        }
    }
}
