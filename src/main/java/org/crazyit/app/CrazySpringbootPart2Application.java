package org.crazyit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrazySpringbootPart2Application {

    public static void main(String[] args) {
        var app = new SpringApplication(CrazySpringbootPart2Application.class);
        // 设置以非Web方式运行Spring Boot项目
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
