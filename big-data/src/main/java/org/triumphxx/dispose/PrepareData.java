package org.triumphxx.dispose;

import org.triumphxx.config.PubConfig;
import org.triumphxx.queue.QueueManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:triumphxx
 * @Date: 2021/12/27
 * @Time: 17:13
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 准备要进行数据提取的数据涉及到的表
 **/
public class PrepareData {
    /**
     * 保存数据提取类型
     */
    private final static QueueManager QUEUE_TYPE_MANAGER = new QueueManager();

    public boolean dealData(Map map) {
        //标记取数线程是否完成
        PubConfig.DATAEMPTY_FG = false;
        List<Map> dataTypeList = new ArrayList<>();
        // 将涉及到的表都放到Map中
        Map<String, String> dataMap = new HashMap<>();
        dataMap.putAll(map);
        dataTypeList.add(dataMap);
        if (dataTypeList != null && dataTypeList.size() > 0) {
            for (Map dataTypemap : dataTypeList) {
                //把所有需要提数的表放到数据队列中
                QUEUE_TYPE_MANAGER.putWorkQueue(dataTypemap);
            }
        }
        //数据准备完成标识
        PubConfig.DATAEMPTY_FG = true;
        return true;
    }
}
