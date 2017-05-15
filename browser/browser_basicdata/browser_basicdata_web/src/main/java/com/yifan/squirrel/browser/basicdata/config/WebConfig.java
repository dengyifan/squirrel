package com.yifan.squirrel.browser.basicdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by yifan on 17-5-7.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.yifan.**.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    //配置jsp视图
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    //配置静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//将静态资源的请求转发到servlet容器中默认的servlet上
    }


    @Bean
    public ResourceHttpRequestHandler resourceHttpRequestHandler(){
        ResourceHttpRequestHandler handler = new ResourceHttpRequestHandler();

        PathResource resource = new PathResource("/scripts/");
        List<Resource> resourceList = new ArrayList<Resource>();
        resourceList.add(resource);
        handler.setLocations(resourceList);
        return handler;
    }


    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setDefaultHandler(resourceHttpRequestHandler());

        Properties properties = new Properties();
        properties.put("/scripts/",resourceHttpRequestHandler());
        mapping.setMappings(properties);
        return mapping;
    }


}
