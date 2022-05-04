package org.triumphxx.compare;

import org.triumphxx.compare.comparer.SortComparator;
import org.triumphxx.compare.node.CompareNode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author:triumphxx
 * @Date: 2021/12/2
 * @Time: 9:58
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: java comparator比较器的用法(外部排序)
 **/
public class ComparatorDemo {
    public static void main(String[] args) {
        CompareNode[] comparatorNodes = new CompareNode[40];
        String province1 ="北京";
        String city1 = "北京市";
        //进行数据准备
        Random random=new Random();
        for (int i = 0; i < 20 ; i++) {
            CompareNode comparatorNode = new CompareNode();
            int rn=random.nextInt(10);
            comparatorNode.setProvince(province1);
            comparatorNode.setCity(city1);
            comparatorNode.setCounty("大兴区"+rn);
            comparatorNode.setDetailedAddress(province1+city1+comparatorNode.getCounty());
            comparatorNodes[i] = comparatorNode;
        }
        for (int i = 20; i < 40 ; i++) {
            CompareNode comparatorNode = new CompareNode();
            int rn=random.nextInt(10);
            comparatorNode.setProvince(province1);
            comparatorNode.setCity(city1);
            comparatorNode.setCounty("大兴区"+rn);
            comparatorNode.setDetailedAddress(province1+city1+comparatorNode.getCounty());
            comparatorNodes[i] = comparatorNode;
        }
        System.out.println("排序前的数据");
        for (int i = 0; i < comparatorNodes.length; i++) {
            System.out.println(comparatorNodes[i]);
        }
        //开始排序
        Arrays.sort(comparatorNodes,new SortComparator());

        System.out.println("排序后的数据");
        for (int i = 0; i < comparatorNodes.length; i++) {
            System.out.println(comparatorNodes[i]);
        }
    }
}
