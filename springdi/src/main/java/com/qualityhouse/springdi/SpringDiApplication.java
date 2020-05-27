package com.qualityhouse.springdi;

import com.qualityhouse.springdi.beans.Planet;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);
		CommandLineStartupRunner clsr = ctx.getBean(CommandLineStartupRunner.class);

		String[] planetNames = clsr.getPlanetNames();
		Planet[] planets = new Planet[planetNames.length];

		for(int i = 0; i<planets.length;i++){
			planets[i] = ctx.getBean(Planet.class);
			planets[i].setName(planetNames[i]);
		}

		for(Planet planet : planets) {
			System.out.println(planet);
		}


	}

}
