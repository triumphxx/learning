package org.triumphxx.sellinglist.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author:triumphxx
 * @Date:2020/5/15
 * @Time:10:22 下午
 * @微信公众号：北漂码农有话说
 * @desc:mybatisplus配置类
 **/
@Configuration
@EnableTransactionManagement
@MapperScan("org.triumphxx.sellinglist.mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
