package com.yifan.squirrel.server.basicdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by yifan on 17-5-12.
 */
@Configuration
@Import(PropertiesConfig.class)
public class RedisConfig {

    @Autowired
    private Environment env;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(Integer.valueOf(env.getProperty("redis.maxIdle")));
        config.setMaxWaitMillis(Long.valueOf(env.getProperty("redis.maxWait")));
        config.setTestOnBorrow(Boolean.getBoolean(env.getProperty("redis.testOnBorrow")));
        return config;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(env.getProperty("redis.host"));
        factory.setPort(Integer.valueOf(env.getProperty("redis.port")));
        factory.setPassword(env.getProperty("redis.pass"));

        factory.setPoolConfig(jedisPoolConfig());
        return factory;
    }


    @Bean
    public RedisTemplate initRedisTemplate(){
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }



}
