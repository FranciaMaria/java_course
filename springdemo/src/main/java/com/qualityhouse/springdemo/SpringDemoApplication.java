package com.qualityhouse.springdemo;

import com.qualityhouse.springdemo.controllers.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringDemoApplication.class, args);
		DemoController dc1 = ctx.getBean(DemoController.class);
		// System.out.println(dc1.sayHello());
		DemoController dc2 = (DemoController) ctx.getBean("demoController");
		// System.out.println(dc2.sayHello());

		if (dc1 == dc2) {
			System.out.println("Isti bean");
		} else {
			System.out.println("Razliciti bean-ovi");
		}
	}

}
