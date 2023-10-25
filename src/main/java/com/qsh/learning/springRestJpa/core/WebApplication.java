package com.qsh.learning.springRestJpa.core;

import com.qsh.learning.springRestJpa.core.car.resources.CarResource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(WebApplication.class)
				.build()
				.run(args);

		// À décommenter quand demander durant la partie 1 du TP1
//		String car = applicationContext.getBean(CarService.class).find();
//		System.out.println(car);

		// À décommenter quand demander durant la partie 2 du TP1
//		String car = applicationContext.getBean(CarResource.class).find();
//		System.out.println(car);
	}
}
