package org.crazyit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class CrazySpringbootPart2Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CrazySpringbootPart2Application.class, args);
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
    }
}
