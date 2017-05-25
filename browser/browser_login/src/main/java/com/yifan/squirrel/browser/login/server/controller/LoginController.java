package com.yifan.squirrel.browser.login.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yifan on 2017/5/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("login.html");
        return mv;
    }
}
