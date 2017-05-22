package com.yifan.squirrel.browser.basicdata.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yifan on 2017/5/22.
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class SpringInterceptor extends HandlerInterceptorAdapter{

    private Logger logger = LoggerFactory.getLogger(SpringInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("interceptor works --------- return true");
        return true;
    }
}
