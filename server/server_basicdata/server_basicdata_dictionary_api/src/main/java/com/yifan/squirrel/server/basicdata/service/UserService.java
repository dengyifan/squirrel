package com.yifan.squirrel.server.basicdata.service;

import com.yifan.squirrel.shared.basicdata.shared.dto.UserDto;
import java.util.List;

/**
 * Created by yifan on 2017/5/8.
 */
public interface UserService {

    List<UserDto> getUserList();

    UserDto getUserById(String userId);

    void updateUserNameById(String userId, String name);

    void deleteUserById(String userId);

    void insertUser(UserDto user);
}
