package com.yifan.squirrel.server.basic.demo.domain;

import java.io.Serializable;

/**
 * Created by yifan on 2017/5/8.
 */
public class User implements Serializable{


    private static final long serialVersionUID = 3348187661014902921L;
    private String userId;

    //姓名
    private String name;
    private String depId;
    private String sex;

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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", depId='" + depId + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
