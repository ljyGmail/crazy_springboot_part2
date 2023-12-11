package org.crazyit.app.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "org.crazyit.app.dao.user",
        sqlSessionFactoryRef = "sqlSessionFactory")
public class UserSqlSessionFactoryConfig {
    @Autowired // 默认注入有@Primary注释修饰的DataSource Bean
    private DataSource firstDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        var factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(firstDataSource);
        // 如有需要，可调用 factoryBean的setMapperLocations来设置XML Mapper的路径
        return factoryBean.getObject();
    }
}
