package com.play.web.back.conf;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: caizhuojie
 * Date: 2017/8/4
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
public class WebInterceptorConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/");
    }
}
