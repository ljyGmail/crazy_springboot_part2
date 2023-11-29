package org.crazyit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CrazySpringbootPart2Application {

    public static void main(String[] args) {
        var application = new SpringApplication(CrazySpringbootPart2Application.class);
        // 设置不再启动Web应用
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

}
