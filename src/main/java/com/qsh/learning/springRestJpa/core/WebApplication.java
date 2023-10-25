package com.qsh.learning.springRestJpa.core;

import com.qsh.learning.springRestJpa.car.resources.CarResource;
import com.qsh.learning.springRestJpa.car.services.CarService;
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

		// À décommenter quand demander durant la partie 1 du TP1
		String car = applicationContext.getBean(CarService.class).find();
		System.out.println(car);

		// À décommenter quand demander durant la partie 2 du TP1
		String car1 = applicationContext.getBean(CarResource.class).find();
		System.out.println(car1);
	}
}
