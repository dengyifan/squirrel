package com.yifan.squirrel.browser.basicdata.stsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yifan on 2017/5/22.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/index")
    public String hello() {
        return "hello.html";
    }

    @RequestMapping("/index2")
    public String hello2(Model model){
        model.addAttribute("message","Welcome form the controller");
        return "hello.html";
    }
}
