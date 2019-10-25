package com.groupthree.ordersystem.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableTransactionManagement
@Configuration
//@MapperScan("com.groupthree.ordersystem.*mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        //指定 MySQL 方言，否则它可能不知道怎么写分页函数
        page.setDialectType("mysql");
        return page;
    }
}