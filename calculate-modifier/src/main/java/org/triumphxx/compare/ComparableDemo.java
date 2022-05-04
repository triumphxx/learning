package org.triumphxx.compare;

import org.triumphxx.compare.node.CompareNode;

import java.util.*;

/**
 * @author:triumphxx
 * @Date: 2021/12/2
 * @Time: 11:12
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: java Comparable比较器的用法(内部排序)
 **/
public class ComparableDemo {
    public static void main(String[] args) {

        List<CompareNode> comparableNodes = new ArrayList();
        String province1 ="北京";
        String city1 = "北京市";
        //进行数据准备
        Random random=new Random();
        for (int i = 0; i < 20 ; i++) {
            int rn=random.nextInt(10);
            CompareNode comparableNode = new CompareNode(province1,city1,"大兴区"+rn,province1+city1+"大兴区"+rn,rn);
//            CompareNode comparableNode = new CompareNode();
//            comparableNode.setProvince(province1);
//            comparableNode.setCity(city1);
//            comparableNode.setCounty("大兴区"+rn);
//            comparableNode.setDetailedAddress(province1+city1+comparableNode.getCounty());
            comparableNodes.add(comparableNode);
        }
        for (int i = 20; i < 40 ; i++) {
            int rn=random.nextInt(10);
            CompareNode comparableNode = new CompareNode(province1,city1,"大兴区"+rn,province1+city1+"大兴区"+rn,rn);
//            CompareNode comparableNode = new CompareNode();
//            comparableNode.setProvince(province1);
//            comparableNode.setCity(city1);
//            comparableNode.setCounty("大兴区"+rn);
//            comparableNode.setDetailedAddress(province1+city1+comparableNode.getCounty());
            comparableNodes.add(comparableNode);
        }
        System.out.println("排序前的数据");
        for (int i = 0; i < comparableNodes.size(); i++) {
            System.out.println(comparableNodes.get(i));
        }
        //开始排序
        Collections.sort(comparableNodes);
        System.out.println("排序后的数据");
        for (int i = 0; i < comparableNodes.size(); i++) {
            System.out.println(comparableNodes.get(i));
        }
    }
}
