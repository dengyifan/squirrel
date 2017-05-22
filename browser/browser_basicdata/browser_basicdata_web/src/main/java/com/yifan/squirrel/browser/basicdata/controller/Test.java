package com.yifan.squirrel.browser.basicdata.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yifan on 2017/5/17.
 */
public class Test {
    public static void main(String[] args){

        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str = format.format(now);
        System.out.println(str);
    }
}
