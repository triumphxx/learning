package org.triumphxx.multiplexer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author:triumphxx
 * @Date:2021/11/20
 * @Time:10:31 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 多路复用IO模型客户端
 **/
public class MultiplexerClient {

    public static void main(String[] args) throws IOException {
        //1.创建SocketChannel
        SocketChannel sc = SocketChannel.open();
        //2.创建Selector
        Selector sel = Selector.open();
        try {
            sc.configureBlocking(false);
            //3.关联SocketChannel和Socket，socket绑定到本机端口
            sc.socket().bind(new InetSocketAddress("localhost", 9090));
            //4.注册到Selector，感兴趣的事件为OP_CONNECT、OP_READ、OP_WRITE
            sc.register(sel, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            int i = 0;
            boolean written = false, done = false;

            ByteBuffer buffer = ByteBuffer.allocate(16);
            while (!done) {
                sel.select();
                //5.从选择器中获取所有注册的通道信息（SelectionKey作为标识）
                Iterator<SelectionKey> it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    //6.获取通道，此处即为上边创建的channel
                    sc = (SocketChannel) key.channel();
                    //7.判断SelectorKey对应的channel发生的事件是否socket连接，并且还没有连接
                    if (key.isConnectable() && !sc.isConnected()) {
                        InetAddress addr = InetAddress.getByName(null);
                        //连接addr和port对应的服务器
                        boolean success = sc.connect(new InetSocketAddress(addr, 9090));
                        if (!success) {
                            sc.finishConnect();
                        }
                    }
                    //8.读与写是非阻塞的：客户端写一个信息到服务器，服务器发送一个信息到客户端，客户端再读
                    if (key.isReadable() && written) {
                        if (sc.read((ByteBuffer) buffer.clear()) > 0) {
                            written = false;
                            String response = buffer.flip().toString();
                            System.out.println(response);
                            if (response.indexOf("END") != -1) {
                                done = true;
                            }
                        }
                    }
                    if (key.isWritable() && !written) {
                        if (i < 10) {
                            sc.write(ByteBuffer.wrap(new String("howdy " + i + "\n").getBytes()));
                        } else if (i == 10) {
                            sc.write(ByteBuffer.wrap("END".getBytes()));
                        }
                        written = true;
                        i++;
                    }
                }
            }
        } finally {
            sc.close();
            sel.close();
        }
    }
}
