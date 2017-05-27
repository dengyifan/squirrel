package com.yifan.squirrel.server.rest.config;

import com.yifan.squirrel.server.rest.controller.HelloController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yifan on 17-5-26.
 */
@ApplicationPath("/")
public class RestfulApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(HelloController.class);
        return classes;
    }
}
