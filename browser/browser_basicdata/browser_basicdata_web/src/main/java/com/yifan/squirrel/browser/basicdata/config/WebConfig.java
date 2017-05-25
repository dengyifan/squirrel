package com.yifan.squirrel.browser.basicdata.config;

import com.google.common.collect.Maps;
import com.yifan.squirrel.browser.basicdata.common.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

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
@ComponentScan("com.yifan.**.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(WebConfig.class);


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ModuleViewResolverInterceptor());
    }


    // 配置jsp视图
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setOrder(2);
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

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("Messages");
        return messageSource;
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
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheable(false);
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
        resolver.setCharacterEncoding("UTF-8");
        String[] viewNameArr = {"*.html","*.xhtml"};
        resolver.setViewNames(viewNameArr);

        Map<String, Object> oldStaticVariables = resolver.getStaticVariables();
        Map<String, Object> staticVariables = Maps.newHashMap(oldStaticVariables);
        staticVariables.put("e", new SpringUtils());
        resolver.setStaticVariables(staticVariables);

        resolver.setOrder(0);
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

    //定义spring文件上传编码
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(500000);
        return multipartResolver;
    }


    //解析json返回数据
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList(converter.getSupportedMediaTypes());
        converter.setSupportedMediaTypes(mediaTypes);
        mediaTypes.addAll(asList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.TEXT_XML));
        converters.add(converter);
    }


    /**
     * 启用 matrix variable
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }

}
