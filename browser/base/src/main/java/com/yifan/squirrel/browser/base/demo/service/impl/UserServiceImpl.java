package com.yifan.squirrel.browser.base.demo.service.impl;


import com.yifan.squirrel.browser.base.demo.domain.User;
import com.yifan.squirrel.browser.base.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yifan on 17-5-8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUserList() {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setUserId("user0008");
        user.setName("张三7");
        user.setDepId("010102");
        user.setSex("男");
        list.add(user);

        //从后端访问
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8100/basic/getUser";
        User user2 = restTemplate.getForObject(url, User.class);
        list.add(user2);
        return list;
    }
}
