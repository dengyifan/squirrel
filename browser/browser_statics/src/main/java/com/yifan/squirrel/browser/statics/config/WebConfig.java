package com.yifan.squirrel.browser.statics.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yifan on 17-5-7.
 *
 * 注意下面多视图的配置：thymeleaf jsp
 * 优化级值越低的级别越高
 * 返回 jsp 时不用添加后缀;
 * 返回 html 时需要返回后缀 如:hello.html
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.yifan.**")
public class WebConfig extends WebMvcConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(WebConfig.class);

    //配置静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//将静态资源的请求转发到servlet容器中默认的servlet上
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("addResourceHandlers");

        /*
        registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/scripts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        */

        registry.addResourceHandler("/statics/**").addResourceLocations("/WEB-INF/statics/");
    }


}
