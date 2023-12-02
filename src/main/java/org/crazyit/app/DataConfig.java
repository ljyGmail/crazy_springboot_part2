package org.crazyit.app;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataConfig {
    @Bean
    @Primary // 设置该DataSource是自动装配的主候选Bean
    @ConfigurationProperties(prefix = "app.datasource.first")
    public DataSource dataSource1() {
        // 指定创建C3P9数据源
        return new ComboPooledDataSource();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.second")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.second.config")
//    @Primary
    public DataSource dataSource2() {
        return dataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
}
