package org.triumphxx.multiplexer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author:triumphxx
 * @Date:2021/11/20
 * @Time:10:31 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 多路复用IO模型服务端
 **/
public class MultiplexerServer {
    public static void main(String[] args) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(16);
        //Socket对应的channel
        SocketChannel ch = null;
        //1.创建ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2.创建选择器Selector
        Selector sel = Selector.open();
        try {
            //3.设置ServerSocketChannel通道为非阻塞
            ssc.configureBlocking(false);
            //4.ServerSocketChannel关联Socket，用于监听连接，使用本地ip和port
            //注意：Socket也对通道进行了改造，直接调Socket.getChannel()将返回bull，除非通过下边与通道关联
            //the expression (ssc.socket().getChannel() != null) is true
            ssc.socket().bind(new InetSocketAddress("localhost", 9090));
            //5.将通道注册到Selector，感兴趣的事件为  连接  事件
            ssc.register(sel, SelectionKey.OP_ACCEPT);

            while (true) {
                //6.没有事件发生时，一直阻塞等待
                sel.select();
                //7.有事件发生时，获取Selector中所有SelectorKey（持有选择器与通道的关联关系）。
                //由于基于操作系统的poll()方法，当有事件发生时，只返回事件个数，无法确定具体通道，故只能对所有注册的通道进行遍历。
                Iterator<SelectionKey> it = sel.selectedKeys().iterator();
                //8.遍历所有SelectorKey，处理事件
                while (it.hasNext()) {
                    SelectionKey sKey = it.next();
                    it.remove();//防止重复处理
                    //9.判断SelectorKey对应的channel发生的事件是否socket连接
                    if (sKey.isAcceptable()) {
                        //10.与ServerSocket.accept()方法相似，接收到该通道套接字的连接，返回SocketChannel，与客户端进行交互
                        ch = ssc.accept();
                        System.out.println(
                                "Accepted connection from:" + ch.socket());
                        //11.设置该SocketChannel为非阻塞模式
                        ch.configureBlocking(false);
                        //12.将该通道注册到Selector中，感兴趣的事件为OP_READ（读）
                        ch.register(sel, SelectionKey.OP_READ);
                    } else {
                        //13.发生非连接事件，此处为OP_READ事件。SelectorKey获取注册的SocketChannel，用于读写
                        ch = (SocketChannel) sKey.channel();
                        //14.将数据从channel读到ByteBuffer中
                        ch.read(buffer);
                        CharBuffer cb = (CharBuffer) buffer.flip();
                        String response = cb.toString();
                        System.out.print("Echoing : " + response);
                        //15.再将获取到的数据会写给客户端
                        ch.write((ByteBuffer) buffer.rewind());
                        if (response.indexOf("END") != -1) {
                            ch.close();
                        }
                        buffer.clear();
                    }
                }
            }
        } finally {
            if (ch != null) {
                ch.close();
            }
            ssc.close();
            sel.close();
        }
    }
}
