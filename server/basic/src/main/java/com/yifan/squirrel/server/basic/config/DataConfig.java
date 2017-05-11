package com.yifan.squirrel.server.basic.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by yifan on 2017/5/8.
 * @MapperScan 后面的属性要配置正确 注意通配符的使用
 */
@Configuration
@MapperScan(basePackages = "com.yifan.**.dao")
public class DataConfig {

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbmvc?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");//防止乱码
        dataSource.setUsername("root");

        //MyNewPass4!
        dataSource.setPassword("1234");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.yifan.**.domain");

        //后面的路径必须存在 不存在会报错
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/yifan/**/dao/*.xml"));
        return sessionFactory;
    }
}
