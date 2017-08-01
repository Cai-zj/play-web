package com.play.web.back.conf;

import com.play.web.cache.conf.CacheConfig;
import com.play.web.dao.conf.DatabaseConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created with IntelliJ IDEA.
 * User: caizhuojie
 * Date: 2017/7/25
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */

/**
 * 项目启动基类
 * -- 整个项目的入口
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 获取配置信息
	 * 类似于web.xml中配置ContextLoaderListener的contextConfigLocation
	 * 只是这个返回的是一个JavaConfig的数组Class
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { BackConfig.class, DatabaseConfig.class, SecurityConfig.class, CacheConfig.class};
	}

	/**
	 * 指定配置类
	 * web 配置类初始化
	 * 类似于web.xml中配置DispatcherServlet的contextConfigLocation
	 * 只是这个返回的是一个JavaConfig的数组Class
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MvcConfig.class };
	}

	/**
	 * 将DispatcherServlet 映射到 "/"
	 * 表示默认 Servlet
	 * 等同于&lt;mapping-url/&gt
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return null;
	}
}
