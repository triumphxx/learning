package org.triumphxx.transaction;

/**
 * @author:triumphxx
 * @Date:2021/6/3
 * @Time:8:45 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试Sping的事务传播特性
 **/
public class TransactionTest {

    public static void main(String[] args) {
        Method01 method01 = new Method01();
        method01.method01();
    }
}
