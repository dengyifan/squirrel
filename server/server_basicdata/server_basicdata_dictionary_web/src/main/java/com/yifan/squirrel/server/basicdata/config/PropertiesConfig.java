package com.yifan.squirrel.server.basicdata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by yifan on 2017/5/11.
 *
 * //如果是相同的key，则最后一个起作用
 */
@Configuration
@PropertySource({
        "classpath:jdbc.properties"
})
public class PropertiesConfig {
}

