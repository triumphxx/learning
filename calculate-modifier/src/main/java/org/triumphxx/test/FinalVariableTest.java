package org.triumphxx.test;

import org.triumphxx.keyword.fin.FinalVariable;

/**
 * @author:triumphxx
 * @Date:2021/4/11
 * @Time:5:33 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试被Final修饰的变量 能否被改变
 **/
public class FinalVariableTest {
    public static void main(String[] args) {
        FinalVariable finalVariable = FinalVariable.getInstance();
        System.out.println(finalVariable.getName());
        System.out.println(finalVariable.getAge());
    }
}
