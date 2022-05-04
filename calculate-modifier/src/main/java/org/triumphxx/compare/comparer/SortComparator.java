package org.triumphxx.compare.comparer;

import org.triumphxx.compare.node.CompareNode;

import java.util.Comparator;

/**
 * @author:triumphxx
 * @Date: 2021/12/2
 * @Time: 10:11
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: ComparatorNode的比较器
 **/
public class SortComparator implements Comparator<CompareNode> {
    //字符分割符号
    private final static String split_fg = "#";

    @Override
    public int compare(CompareNode o1, CompareNode o2) {
        //将排序条件拼装为一个字符串，根据该字符串进行排序
        StringBuffer sortSb1 = new StringBuffer();
        sortSb1.append(o1.getProvince()).append(split_fg);
        sortSb1.append(o1.getCity()).append(split_fg);
        sortSb1.append(o1.getCounty());

        StringBuffer sortSb2 = new StringBuffer();
        sortSb2.append(o2.getProvince()).append(split_fg);
        sortSb2.append(o2.getCity()).append(split_fg);
        sortSb2.append(o2.getCounty());

        if (sortSb1.toString().compareTo(sortSb2.toString()) >= 0) {
            if (sortSb1.toString().compareTo(sortSb2.toString()) == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }
}
