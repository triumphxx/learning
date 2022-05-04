package org.triumphxx.keyword.sup.sub;

import org.triumphxx.keyword.sup.SuperClass;

/**
 * @author:triumphxx
 * @Date:2021/4/12
 * @Time:9:12 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class SubSuperClass extends SuperClass {

    private int age;

    /**
     *
     * @param name
     * @param age
     */
    public SubSuperClass(String name,int age) {
        super(name);
        this.age = age;
    }
}
