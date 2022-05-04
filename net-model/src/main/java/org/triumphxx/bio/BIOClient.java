package org.triumphxx.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author:triumphxx
 * @Date:2021/4/22
 * @Time:10:29 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: BIO网络编程模型客户端
 **/
public class BIOClient {
    public static void main(String[] args) {
        try {
            //连接服务端
            Socket socket = new Socket("localhost", 9000);
            //准备给服务端发送的信息
            socket.getOutputStream().write("hello server".getBytes());
            //开始发送信息
            socket.getOutputStream().flush();
            System.out.println("客户端信息发送完成");
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            System.out.println("服务端返回的信息为：" + new String(bytes));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
