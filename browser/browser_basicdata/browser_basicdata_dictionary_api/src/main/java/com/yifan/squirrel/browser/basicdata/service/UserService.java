package com.yifan.squirrel.browser.basicdata.service;


import com.yifan.squirrel.shared.basicdata.shared.dto.UserDto;

import java.util.List;

/**
 * Created by yifan on 17-5-8.
 */
public interface UserService {
    List<UserDto> getUserList();
}
