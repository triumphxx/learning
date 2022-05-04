package org.triumphxx.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:triumphxx
 * @Date:2021/6/3
 * @Time:8:46 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试方法1
 **/
public class Method02 {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String method02() {
        int a = 1 / 0;
        return String.valueOf(a);
    }
}
