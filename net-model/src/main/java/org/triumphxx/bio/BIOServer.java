package org.triumphxx.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:triumphxx
 * @Date:2021/4/22
 * @Time:10:29 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: BIO网络编程模型服务端
 **/
public class BIOServer {

    public static void main(String[] args) throws IOException {
        //创建一个Socket服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //服务端启动后等待着客户端的请求
        while (true) {
            System.out.println("等待连接");
            //阻塞的方法,等待连接
            final Socket socket = serverSocket.accept();
            System.out.println("有客户端的连接进来了");
            //BIO的特点，每进来一个客户端的请求都需要创建线程去处理
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    dealMessage(socket);
                }
            });
        }

    }

    public static void dealMessage(Socket socket) {
        System.out.println("线程名称为" + Thread.currentThread().getName());
        System.out.println("开始读取信息");
        InputStream inputStream = null;
        try {
            byte[] bytes = new byte[1024];
            inputStream = socket.getInputStream();
            inputStream.read(bytes);
            System.out.println("接收到客户端的信息为：" + new String(bytes));
            socket.getOutputStream().write("客户端你好，接收到了你的信息".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
