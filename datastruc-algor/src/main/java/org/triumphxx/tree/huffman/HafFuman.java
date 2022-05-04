package org.triumphxx.tree.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:triumphxx
 * @Date:2021/1/22
 * @Time:上午10:33
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 赫夫曼树
 **/
public class HafFuman {

    //统计相同的字符出现的次数
    public Map<Byte, Integer> statistics(byte[] bytes) {
        Map<Byte, Integer> map = null;
        if (bytes.length > 0) {
            map = new HashMap();
            for (byte aByte : bytes) {
                Integer count = map.get(aByte);
                if (count == null) {
                    map.put(aByte, 1);
                } else {
                    map.put(aByte, count + 1);
                }
            }
        }
        return map;
    }


    public Map<String, Integer> statistics(String[] s) {
        Map<String, Integer> map = null;
        if (s.length > 0) {
            map = new HashMap();
            for (String string : s) {
                Integer count = map.get(string);
                if (count == null) {
                    map.put(string, 1);
                } else {
                    map.put(string, count + 1);
                }
            }
        }
        return map;
    }
}
