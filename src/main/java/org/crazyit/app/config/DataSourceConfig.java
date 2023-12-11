package org.crazyit.app.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.postgresql.xa.PGXADataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.sql.XADataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    // 通过@ConfigurationProperties注解控制该Bean调用对应的setter方法
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public XADataSource initFirstDatasource() {
        return new MysqlXADataSource();
    }

    @Bean(name = "firstDataSource")
    @Primary
    public DataSource firstDataSource() {
        System.out.println("创建第1个数据源");
        var xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(initFirstDatasource());
        xaDataSource.setUniqueResourceName("mysqlDataSource");
        xaDataSource.setPoolSize(5);
        return xaDataSource;
    }

    @Bean
    // 通过@ConfigurationProperties注解控制该Bean调用对应的setter方法
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public XADataSource initSecondDatasource() {
        return new PGXADataSource();
    }

    @Bean(name = "secondDataSource")
    public DataSource secondDataSource() {
        System.out.println("创建第2个数据源");
        var xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(initSecondDatasource());
        xaDataSource.setUniqueResourceName("pgsqlDataSource");
        xaDataSource.setPoolSize(5);
        return xaDataSource;
    }
}
