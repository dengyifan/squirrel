package com.yifan.squirrel.browser.basicdata.stsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yifan on 2017/5/22.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    private String pageName = "hello.html";

    /**
     * 直接返回一个页面
     * @return
     */
    @RequestMapping("/index")
    public String hello() {
        return pageName;
    }

    /**
     * 向页面返回数据值 用于页面展示
     * @param model
     * @return
     */
    @RequestMapping("/index2")
    public String hello2(Model model){
        model.addAttribute("message","Welcome form the controller");
        return pageName;
    }


    /**
     * 从 url 串中获取请求的参数 并返回给页面
     * 并设置默认值
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping("/index3")
    public String hello3(@RequestParam(name="userName",defaultValue = "World") String userName,Model model){
        model.addAttribute("message","Hello, " + userName);
        return pageName;
    }
}





































