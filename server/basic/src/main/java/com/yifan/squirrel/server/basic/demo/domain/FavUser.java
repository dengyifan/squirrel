package com.yifan.squirrel.server.basic.demo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yifan on 2017/5/8.
 */
public class FavUser implements Serializable{


    private static final long serialVersionUID = 4493102548426050788L;
    private String userId;
    private String userName;
    private int userAge;
    private Date createDate;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
