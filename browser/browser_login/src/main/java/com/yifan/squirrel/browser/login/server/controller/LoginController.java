package com.yifan.squirrel.browser.login.server.controller;

import com.yifan.squirrel.browser.login.shared.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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


    @RequestMapping("/thymeleaf")
    public ModelAndView thymeleaf(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("thymeleaf.html");
        mv.addObject("today","2017-05-26");
        Calendar instance = Calendar.getInstance();
        mv.addObject("now", instance);


        User user = new User(1000,"张三",0,29);
        request.setAttribute("user",user);


        mv.addObject("date",new Date());

        List<Date> dateList = new ArrayList<Date>();
        dateList.add(new Date());

        instance.add(Calendar.DAY_OF_MONTH,1);
        dateList.add(instance.getTime());

        instance.add(Calendar.DAY_OF_MONTH,2);
        dateList.add(instance.getTime());


        return mv;
    }
}
