package com.yifan.squirrel.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by yifan on 2017/5/12.
 */
@Configuration
@PropertySource({
        "classpath:jdbc.properties"
})
public class PropertiesConfig {
}
