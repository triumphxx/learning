package org.triumphxx;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @author:triumphxx
 * @Date:2021/11/10
 * @Time:10:52 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class IOTest {
    public static void main(String[] args) {
        LinkedList<SocketChannel> clients = new LinkedList<>();
        //服务器地址
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 9000);
        for (int i = 10000; i < 65000; i++) {
            try {
                // 打开客户端
                SocketChannel client = SocketChannel.open();
                //绑定客户端地址
                client.bind(new InetSocketAddress("localhost", i));
                //连接服务端
                client.connect(serverAddress);
                clients.add(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
