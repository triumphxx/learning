package org.triumphxx.keyword.th;

/**
 * @author:triumphxx
 * @Date:2021/4/12
 * @Time:8:51 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: this关键字的用法：1、this是自身的一个对象，代表对象本身，
 * 可以理解为指向对象本身的一个指针
 **/
public class ThisClass {

    public class Person {
        private String name;
        private int age;

        /**
         * 2、 当形参和成员变量命名一样时加以区分 用this
         *
         * @param name
         */
        public Person(String name) {
            this.name = name;
        }

        /**
         * 3、 引用本类的构造函数
         *
         * @param name
         * @param age
         */
        public Person(String name, int age) {
            this(name);
            this.age = age;
        }
    }
}
