package com.yifan.squirrel.server.basicdata.config;


import org.apache.log4j.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yifan on 2017/5/12.
 */
@Configuration
@Import(PropertiesConfig.class)
public class LoggingConfig {
    public LoggingConfig() {}

    @Bean
    public ConsoleAppender consoleAppender() {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.ALL);
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern("%d %-5p [%c{1}] %m %n");
        consoleAppender.setLayout(patternLayout);
        return consoleAppender;
    }


    @Bean
    public FileAppender fileAppender() {
        RollingFileAppender fileAppender = new RollingFileAppender();
        fileAppender.setThreshold(Level.ALL);
        fileAppender.setFile("build.log");
        fileAppender.setMaxFileSize("100KB");
        fileAppender.setMaxBackupIndex(1);
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern("%d %-5p  [%c{1}] %m %n");
        fileAppender.setLayout(patternLayout);
        return fileAppender;
    }


    @Bean
    public Logger registerSpringLogger() {
        Logger logger = Logger.getLogger("org.springframework");
        logger.addAppender(consoleAppender());
        return logger;
    }


    @Bean
    public Logger registerSquirrelLogger() {
        Logger logger = Logger.getLogger("com.yifan.squirrel");
        logger.addAppender(consoleAppender());
        return logger;
    }


}
