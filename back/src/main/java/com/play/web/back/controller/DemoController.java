package com.play.web.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: caizhuojie
 * Date: 2017/8/1
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
@Controller

public class DemoController {
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String toDemo(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        int demoId = Integer.parseInt(request.getParameter("id"));
        if (demoId == 1) {
            model.addAttribute("state", 200);
        } else {
            model.addAttribute("state", 404);
        }
        return "index/demo";
    }
}
