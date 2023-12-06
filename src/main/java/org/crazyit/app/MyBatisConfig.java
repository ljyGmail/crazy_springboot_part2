package org.crazyit.app;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {
    // 在Spring容器中主动定义ConfigurationCustomizer Bean
    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                // 下面即可对Configuration进行设置
                configuration.setCacheEnabled(true);
            }
        };
    }
}
