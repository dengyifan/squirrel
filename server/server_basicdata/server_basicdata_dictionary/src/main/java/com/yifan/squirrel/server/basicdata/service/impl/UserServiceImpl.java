package com.yifan.squirrel.server.basicdata.service.impl;


import com.yifan.squirrel.server.basicdata.dao.UserDao;
import com.yifan.squirrel.server.basicdata.service.UserService;
import com.yifan.squirrel.shared.basicdata.shared.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by yifan on 2017/5/8.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    public List<UserDto> getUserList() {
        logger.info("测试 log4j 日志记录__________________");
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
