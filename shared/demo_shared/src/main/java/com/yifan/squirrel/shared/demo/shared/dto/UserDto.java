package com.yifan.squirrel.shared.demo.shared.dto;

import java.io.Serializable;

/**
 * Created by yifan on 2017/5/11.
 */
public class UserDto implements Serializable{


    private static final long serialVersionUID = 2696379849774630366L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String userId;

    //姓名
    private String name;
    private String depId;
    private String sex;



}
