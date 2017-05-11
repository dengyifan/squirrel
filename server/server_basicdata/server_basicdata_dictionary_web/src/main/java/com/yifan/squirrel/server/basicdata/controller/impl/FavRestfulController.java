package com.yifan.squirrel.server.basicdata.controller.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yifan.squirrel.server.basicdata.service.UserService;
import com.yifan.squirrel.shared.basicdata.controller.IFavRestfulController;
import com.yifan.squirrel.shared.basicdata.shared.dto.FavUserDto;
import com.yifan.squirrel.shared.basicdata.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by yifan on 2017/5/8.
 */
@Service
public class FavRestfulController implements IFavRestfulController{

    @Autowired
    UserService userService;

    @Override
    public String getUserName(String name){
        return name;
    }

    @Override
    public FavUserDto getFavUser(String userName, String userId, int userAge){
        FavUserDto favUser = new FavUserDto();
        favUser.setUserId(userId);
        favUser.setUserName(userName);
        favUser.setUserAge(userAge);
        return favUser;
    }

    @Override
    public FavUserDto getFavUserBody(String body){
        ObjectMapper mapper = new ObjectMapper();
        FavUserDto favUser = null;
        try {
            favUser = mapper.readValue(body,  FavUserDto.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favUser;
    }

    @Override
    public FavUserDto buildRestUser(){
        FavUserDto favUser = new FavUserDto();
        favUser.setUserId("mm");
        favUser.setUserName("美眉");
        favUser.setUserAge(18);
        favUser.setCreateDate(new Date());
        return favUser;
    }


    @Override
    public UserDto getUser(){
        UserDto user = userService.getUserList().get(0);
        return user;
    }

    @Override
    public List<UserDto> getAllUser() {
        return userService.getUserList();
    }



}
