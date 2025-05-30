package com.jonas.springdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceConfig {

    private final Environment env;

    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.h2")
    public DataSourceProperties h2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource(
            @Qualifier("h2DataSourceProperties") DataSourceProperties h2Props,
            @Qualifier("mysqlDataSourceProperties") DataSourceProperties mysqlProps) {
        
        String dataSourceType = env.getProperty("app.datasource.type", "h2");
        
        if ("mysql".equals(dataSourceType)) {
            return mysqlProps.initializeDataSourceBuilder().build();
        } else {
            return h2Props.initializeDataSourceBuilder().build();
        }
    }
}