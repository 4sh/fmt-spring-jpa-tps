package com.qsh.learning.springRestJpa.core;

import com.qsh.learning.springRestJpa.core.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qsh")
public class WebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(WebApplication.class)
				.build()
				.run(args);

		String userId = applicationContext.getBean(AppConfig.class).userId;
		System.out.printf("Current user: %s%n", userId);
	}
}
