package com.groupthree.ordersystem.config;

import com.groupthree.ordersystem.Interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 注册自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        log.info("登录拦截，未登录无法访问其他界面！");
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }
}
