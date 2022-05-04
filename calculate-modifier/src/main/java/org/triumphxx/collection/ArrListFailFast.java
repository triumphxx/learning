package org.triumphxx.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author:triumphxx
 * @Date:2021/6/6
 * @Time:11:20 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: ArryList的快速失败机制 验证，
 *
 **/
public class ArrListFailFast {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Integer integer : list) {
            list.add(integer);
            System.out.println(integer);
        }


//        list.forEach((integer)->{
//            System.out.println(integer);
//        });
    }
}
