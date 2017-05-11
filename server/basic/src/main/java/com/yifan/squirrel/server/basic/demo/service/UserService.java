package com.yifan.squirrel.server.basic.demo.service;


import com.yifan.squirrel.server.basic.demo.domain.User;

import java.util.List;

/**
 * Created by yifan on 2017/5/8.
 */
public interface UserService {

    List<User> getUserList();

    User getUserById(String userId);

    void updateUserEmailById(String userId, String sex);

    void deleteUserById(String userId);

    void insertUser(User user);
}
