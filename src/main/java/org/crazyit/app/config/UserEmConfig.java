package org.crazyit.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
// 使用该注解指定自行配置JPA Repository
@EnableJpaRepositories(
        entityManagerFactoryRef = "userEntityManager",
        // 使用默认的事务管理器，
        // 当全局JTA事务管理器的id为transactionManager时，该属性可省略
        transactionManagerRef = "transactionManager",
        basePackages = {"org.crazyit.app.dao.user"}) // 设置DAO组件所在位置
public class UserEmConfig {
    @Autowired
    private DataSource firstDataSource;

    @Bean(name = "userEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        // 通过自动配置的EntityManagerFactoryBuilder创建
        // LocalContainerEntityManagerFactoryBean时
        // spring.jpa.hibernate.*配置的属性不会自动起作用
        // spring.jpa.*和spring.jpa.properties.*的属性会自动起作用
        var em = builder.dataSource(firstDataSource)
                // 设置实体类所在的包
                .packages("org.crazyit.app.domain.user")
                .persistenceUnit("userPersistenceUnit")
                .build();
        // 如果配置文件中没指定properties.javax.persistence.transactionType，
        // 此处就需要通过如下代码来设置使用JTA全局事务
        // em.setJpaPropertyMap(Map.of("javax.persistence.transactionType", "JTA"));
        return em;
    }
}
