package com.yifan.squirrel.server.basicdata.config;


import com.yifan.squirrel.server.basicdata.filter.CORSFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by yifan on 2017/5/8.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        Log4jConfigListener log4jListener = new Log4jConfigListener();


        servletContext.addListener(log4jListener);
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter[] singleton = { new CORSFilter()};
        return singleton;
    }


}

