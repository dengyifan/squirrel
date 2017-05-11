package com.yifan.squirrel.browser.base.demo.service.impl;


import com.yifan.squirrel.browser.base.api.server.service.UserService;
import com.yifan.squirrel.shared.demo.shared.dto.UserDto;
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
    public List<UserDto> getUserList() {
        List<UserDto> list = new ArrayList<UserDto>();
        UserDto user = new UserDto();
        user.setUserId("user0008");
        user.setName("张三7");
        user.setDepId("010102");
        user.setSex("男");
        list.add(user);

        //从后端访问
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8100/basic/getUser";
        UserDto user2 = restTemplate.getForObject(url, UserDto.class);
        list.add(user2);
        return list;
    }
}
