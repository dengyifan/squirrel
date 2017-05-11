package com.yifan.squirrel.shared.basicdata.shared.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yifan on 2017/5/11.
 */
public class FavUserDto implements Serializable{


    private static final long serialVersionUID = 3378796784523169381L;
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
