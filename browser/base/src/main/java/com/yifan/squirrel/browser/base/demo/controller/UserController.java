package com.yifan.squirrel.browser.base.demo.controller;

import com.yifan.squirrel.browser.base.api.server.service.UserService;
import com.yifan.squirrel.shared.demo.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yifan on 17-5-7.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/getAllUser", method = RequestMethod.GET)
    public String getUserList(Model model){
        List<UserDto> list = userService.getUserList();
        model.addAttribute("list",list);
        return "showUsers";
    }
}
