package com.yifan.squirrel.browser.basicdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yifan on 17-5-14.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getUserList(Model model){
        return "login";
    }

}
