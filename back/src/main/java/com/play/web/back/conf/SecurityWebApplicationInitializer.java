package com.play.web.back.conf;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created with IntelliJ IDEA.
 * User: caizhuojie
 * Date: 2017/7/25
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */

/**
 * 配置Delegating-FilterProxy
 * 继承AbstractSecurityWebApplicationInitializer会自动注册DelegatingFilterProxy
 * 等价于xml配置
 * 安全方面的启动组件，与WebApplicationInitializer 继承关系类似
 * 可以启动加载一些安全相关的配置和类
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}