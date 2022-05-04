package org.triumphxx.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;


/**
 * @author:triumphxx
 * @Date:2021/11/12
 * @Time:11:03 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: AIO编程模型服务端
 **/
public class AIOServer {

    public AsynchronousServerSocketChannel serverSocketChannel;

    public static void main(String[] args) throws Exception {
        //启动服务器，并监听客户端
        new AIOServer().listen();
        //因为是异步IO执行,让主线程睡眠但不关闭
        Thread.sleep(Integer.MAX_VALUE);
    }

    public void listen() throws Exception {
        //打开一个服务端通道
        serverSocketChannel = AsynchronousServerSocketChannel.open();
        //监听9090端口
        serverSocketChannel.bind(new InetSocketAddress(9090));
        //监听
        serverSocketChannel.accept(this, new CompletionHandler<AsynchronousSocketChannel, AIOServer>() {
            @Override
            public void completed(AsynchronousSocketChannel client, AIOServer attachment) {
                try {
                    if (client.isOpen()) {
                        System.out.println("接收到新的客户端的连接，地址：" + client.getRemoteAddress());
                        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        //读取客户端发送的数据
                        client.read(byteBuffer, client, new CompletionHandler<Integer, AsynchronousSocketChannel>() {
                            @Override
                            public void completed(Integer result, AsynchronousSocketChannel attachment) {
                                try {
                                    //读取请求，处理客户端发送的数据
                                    byteBuffer.flip();
                                    String content = Charset.defaultCharset().newDecoder().decode(byteBuffer).toString();
                                    System.out.println("服务端接受到客户端发来的数据：" + content);
                                    //向客户端发送数据
                                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                    writeBuffer.put("Server send".getBytes());
                                    writeBuffer.flip();
                                    attachment.write(writeBuffer).get();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
                                try {
                                    exc.printStackTrace();
                                    attachment.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //当有新的客户端接入的时候，直接调用accept的方法，递归执行下去，这样可以保证多个客户端都可以阻塞
                    attachment.serverSocketChannel.accept(attachment, this);
                }
            }

            @Override
            public void failed(Throwable exc, AIOServer attachment) {
                exc.printStackTrace();
            }
        });
    }


}
