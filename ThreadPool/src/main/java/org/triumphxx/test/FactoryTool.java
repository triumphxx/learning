package org.triumphxx.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author:triumphxx
 * @Date: 2022/1/6
 * @Time: 10:22
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class FactoryTool implements Runnable {
    public static final Logger LOGGER = LogManager.getLogger(FactoryTool.class);

    List<String> list;

    public FactoryTool(List list) {
        this.list = list;
    }

    public void add(List list) {
        list.add(new Object());
    }

    @Override
    public void run() {
        add(list);
        LOGGER.info("添加元素完成");
    }
}
