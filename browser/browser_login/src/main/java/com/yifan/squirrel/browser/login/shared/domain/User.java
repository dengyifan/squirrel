package com.yifan.squirrel.browser.login.shared.domain;

import java.io.Serializable;

/**
 * Created by yifan on 2017/5/26.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4062699543025063951L;


    private int id;
    private String name;
    private int gender;
    private int age;

    public User() {}

    public User(int id, String name, int gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
