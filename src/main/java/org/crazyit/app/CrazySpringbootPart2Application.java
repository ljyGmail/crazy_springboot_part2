package org.crazyit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrazySpringbootPart2Application {

	public static void main(String[] args) {
		var app = new SpringApplication(CrazySpringbootPart2Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}

}
