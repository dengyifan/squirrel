package com.yifan.squirrel.server.basicdata.service.impl;


import com.yifan.squirrel.server.basicdata.dao.UserDao;
import com.yifan.squirrel.server.basicdata.service.UserService;
import com.yifan.squirrel.shared.basicdata.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by yifan on 2017/5/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public List<UserDto> getUserList() {
        List<UserDto> list = userDao.getUserList();
        return list;
    }

    public UserDto getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public void updateUserEmailById(String userId, String sex) {
        userDao.updateUserEmailById(userId, sex);
    }

    public void deleteUserById(String userId) {
        userDao.deleteUserById(userId);
    }

    public void insertUser(UserDto user) {
        userDao.insertUser(user);
    }
}
