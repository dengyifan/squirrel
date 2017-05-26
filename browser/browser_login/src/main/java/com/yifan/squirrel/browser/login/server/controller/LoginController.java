package com.yifan.squirrel.browser.login.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yifan on 2017/5/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private Environment env;

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("login.html");

        String browserStatics = env.getProperty("squirrel.browser.statics");
        mv.getModel().put("browserStaticsPath",browserStatics);
        return mv;
    }
}
