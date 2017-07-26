package com.play.web.back.conf;

//import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created with IntelliJ IDEA.
 * User: caizhuojie
 * Date: 2017/7/25
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */

@EnableWebMvc //启用Spring MVC
@EnableAspectJAutoProxy
@EnableScheduling
@ComponentScan(basePackages =   //启用组件扫描
        {"com.play.web.back.controller",
                "com.play.web.service",
                "com.play.web.task"})
@MapperScan("com.play.web.dao.mapper")
public class MvcConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置jsp视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        bean.setPrefix("/WEB-INF/pages/");
        bean.setSuffix(".jsp");
        return bean;
    }

    /**
     *  配置公共部分解析器（静态资源的处理）
     * @return
     */
    @Bean(name="multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver(){
		CommonsMultipartResolver common = new CommonsMultipartResolver();
		common.setMaxUploadSize(10 * 1024 * 1024);//10M
		return common;
	}
    
}