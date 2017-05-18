package com.yifan.squirrel.browser.basicdata.controller;

/**
 * Created by yifan on 2017/5/17.
 */
public class Test {
    public static void main(String[] args){

        int tempLimit = 100;
        int modVal = tempLimit % 3;
        System.out.println(modVal);

        int size = (tempLimit / 3) ;



        System.out.println(size);

        System.out.println(size + modVal);
    }
}
