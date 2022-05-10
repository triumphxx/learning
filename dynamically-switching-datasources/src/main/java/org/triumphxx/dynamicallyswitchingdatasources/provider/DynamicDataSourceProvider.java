package org.triumphxx.dynamicallyswitchingdatasources.provider;


import javax.sql.DataSource;
import java.util.Map;

/**
 * @author:triumphxx
 * @Date: 2022/5/10
 * @Time: 15:25
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 数据源配置类获取配置文件中的信息
 **/
public interface DynamicDataSourceProvider {
    String DEFAULT_DATASOURCE = "master";
    /**
     * 加载所有的数据源
     * @return
     */
    Map<String, DataSource> loadDataSources();
}
