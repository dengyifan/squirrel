package com.yifan.squirrel.browser.basicdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yifan on 17-5-14.
 */
@Controller
@RequestMapping("/vue")
public class VueController {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getUserList(Model model){
        return "/vue/index";
    }



    @RequestMapping(path = "/instance", method = RequestMethod.GET)
    public String instance(Model model){
        return "/vue/instance";
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String list(Model model){
        return "/vue/list";
    }


    @RequestMapping(path = "/event", method = RequestMethod.GET)
    public String event(Model model){
        return "/vue/event";
    }


    @RequestMapping(path = "/component", method = RequestMethod.GET)
    public String component(Model model){
        return "/vue/component";
    }

}
