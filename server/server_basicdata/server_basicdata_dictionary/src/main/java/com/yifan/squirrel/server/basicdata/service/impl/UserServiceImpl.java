package com.yifan.squirrel.server.basicdata.service.impl;


import com.yifan.squirrel.server.basicdata.dao.UserDao;
import com.yifan.squirrel.server.basicdata.redis.RedisGeneratorDao;
import com.yifan.squirrel.server.basicdata.service.UserService;
import com.yifan.squirrel.shared.basicdata.shared.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by yifan on 2017/5/8.
 */
@Service
public class UserServiceImpl extends RedisGeneratorDao<String,UserDto> implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    public List<UserDto> getUserList() {
        logger.info("测试 log4j 日志记录__________________");
        List<UserDto> list = userDao.getUserList();
        return list;
    }

    public UserDto getUserById(String userId) {

        getFromRedis(userId);

        return userDao.getUserById(userId);
    }

    public void updateUserNameById(String userId, String name) {
        userDao.updateUserNameById(userId,name);


        if(getFromRedis(userId) == null) {
            throw new NullPointerException("数据行不存在, key = " + userId);
        }


        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(userId);
                byte[] nameValue = serializer.serialize(name);
                redisConnection.set(key,nameValue);
                return true;
            }
        });


    }

    public void deleteUserById(String userId) {
        userDao.deleteUserById(userId);

        redisTemplate.delete(userId);
    }

    public void insertUser(UserDto user) {
        userDao.insertUser(user);

        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(user.getUserId());
                byte[] name = serializer.serialize(user.getName());
                return redisConnection.setNX(key,name);
            }
        });

        logger.info("insertUser result:" + result);
    }


    public UserDto getFromRedis(String keyId) {

        logger.info("getFromRedis keyId:" + keyId);

        UserDto result = redisTemplate.execute(new RedisCallback<UserDto>() {
            @Override
            public UserDto doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(keyId);
                byte[] value = redisConnection.get(key);
                if(value == null) {
                    return null;
                }

                String name = serializer.deserialize(value);
                UserDto user = new UserDto();
                user.setUserId(keyId);
                user.setName(name);
                return user;
            }
        });


        logger.info("getFromRedis keyId:" + keyId + "result:" + result);

        return result;
    }
}
