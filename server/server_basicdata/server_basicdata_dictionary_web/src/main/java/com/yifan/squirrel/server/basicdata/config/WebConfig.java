package com.yifan.squirrel.server.basicdata.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yifan on 2017/5/8.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.yifan.**.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
}