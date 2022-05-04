package org.triumphxx.cal;

/**
 * @author:triumphxx
 * @Date:2021/4/11
 * @Time:4:28 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试计算，用最简答的方式计算2*8
 **/
public class Calculate {
    public static void main(String[] args) {
        //2 左移（<<）3位相当于 2 * 2的三次方,2右移（>>）3位 相当于2 除以2的3次方
        int num = 2 << 3;
        System.out.println(num);
        //四舍五入原理 在参数上加 0.5 然后进行下取整
        long round = Math.round(11.5);
        long round1 = Math.round(-11.5);
        System.out.println(round);
        System.out.println(round1);
    }
}
