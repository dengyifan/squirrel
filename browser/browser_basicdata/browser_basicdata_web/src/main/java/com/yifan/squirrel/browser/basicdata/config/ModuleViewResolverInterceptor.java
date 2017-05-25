package com.yifan.squirrel.browser.basicdata.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by yifan on 2017/5/22.
 * 用于请求过来之后动态设置视图的路径
 * 如：com.yifan.squirrel.browser.basicdata.server.controller 里的方法过来的请求
 * 返回的视图为 /vue/index
 *
 * 通过该拦截器的处理请视图动态的设置为
 *
 * basicdata/vue/index
 *
 * 则是因为 web 工种里的 WEB-INF 下面的页面是按模块动态生成的
 *
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class ModuleViewResolverInterceptor extends HandlerInterceptorAdapter{


    private Logger logger = LoggerFactory.getLogger(ModuleViewResolverInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("interceptor works --------- return true");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String moduleBeanName = ((HandlerMethod) handler).getBeanType().getName();
        String module = Arrays.stream(moduleBeanName.split("\\.")).skip(4).limit(1).findFirst().get();

        logger.debug("interceptor postHandle --------- module:" + module);

        String viewName = module + "/" + modelAndView.getViewName();
        modelAndView.setViewName(viewName);
    }
}
