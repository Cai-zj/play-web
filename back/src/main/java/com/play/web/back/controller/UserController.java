package com.play.web.back.controller;

import com.play.web.bean.User;
import com.play.web.cache.CacheKey;
import com.play.web.cache.CacheService;
import com.play.web.service.UserService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: caizhuojie
 * Date: 2017/7/25
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */


/**
 * 用户请求处理器
 * Created by admin on 16/8/6.
 */
@Controller  //声明为一个控制器
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/home",produces="text/html;charset=UTF-8", method = RequestMethod.GET)   //处理对 “/home” 的GET请求
    @PreAuthorize("isAuthenticated()")// isAuthenticated 如果用户不是匿名用户就返回true
    public String showHomePage() {
        try {
            
            User user = userService.loadUserByUsername("admin");

//            测试缓存服务
//            缓存用户对象到redis,以用户ID区分
            cacheService.set(CacheKey.LOGIN_USER_KEY + user.getId(), JSON.toJSONString(user));
//            从缓存中取出
            String userStr = cacheService.get(CacheKey.LOGIN_USER_KEY + user.getId());
//            进行反序列化
            User u = JSON.parseObject(userStr, User.class);
            if(u != null){
                logger.info("user:{}", u);
            }
            logger.info("load user ");
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(), e);
        }

        return "/index/index";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:../../login.jsp";
    }

}
