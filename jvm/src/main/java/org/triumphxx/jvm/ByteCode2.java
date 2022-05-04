package org.triumphxx.jvm;

import lombok.Data;

/**
 * @author:triumphxx
 * @Date:2021/5/8
 * @Time:8:37 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@Data
public class ByteCode2 {
    int age;
    volatile String name;

    synchronized void m() {

    }
}
