package com.yifan.squirrel.browser.basicdata.server.controller;

import java.util.Arrays;

/**
 * Created by yifan on 2017/5/17.
 */
public class Test {
    public static void main(String[] args){

        String str = "com.yifan.squirrel.browser.basicdata.server.controller";
        String s = Arrays.stream(str.split("\\.")).skip(4).limit(1).findFirst().get();
        System.out.println(s);

    }
}
