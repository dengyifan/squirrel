package com.yifan.squirrel.shared.basicdata.controller;

import com.yifan.squirrel.shared.basicdata.shared.dto.FavUserDto;
import com.yifan.squirrel.shared.basicdata.shared.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yifan on 2017/5/11.
 */
@RestController
public interface IFavRestfulController {

    @RequestMapping(value="/getUserName",method= RequestMethod.POST)
    String getUserName(@RequestParam(value="name") String name);

    @RequestMapping("getFavUser")
    FavUserDto getFavUser(@RequestParam("userName") String userName, String userId, int userAge);

    @RequestMapping("getFavUserBody")
    FavUserDto getFavUserBody(@RequestBody String body);

    @RequestMapping(value="buildRestUser")
    FavUserDto buildRestUser();

    @RequestMapping(value="getUser")
     UserDto getUser();


    @RequestMapping(value="getAllUser")
    public List<UserDto> getAllUser();
}
