package com.yifan.squirrel.browser.basicdata.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

/**
 * Created by yifan on 17-5-7.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.yifan.**.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(WebConfig.class);


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


    /**
     * thymeleaf 整合
     * @param context
     * @return
     */
    @Bean
    public ServletContextTemplateResolver templateResolver(ServletContext context) {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }


    /**
     * thymeleaf 整合
     * @param context
     * @return
     */
    @Bean
    public SpringTemplateEngine templateEngine(ServletContext context){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver(context));
        return templateEngine;
    }


    /**
     * thymeleaf 整合
     * @param context
     * @return
     */
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(ServletContext context) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine(context));
        resolver.setOrder(1);
        String[] viewNameArr = {"*.html","*.xhtml"};
        resolver.setViewNames(viewNameArr);
        return resolver;
    }

    /**
     * thymeleaf 整合
     * @return
     */
    @Bean
    public SpringResourceTemplateResolver resourceTemplateResolver() {

        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }

}
