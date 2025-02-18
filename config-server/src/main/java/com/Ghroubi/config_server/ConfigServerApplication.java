package com.Ghroubi.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import io.github.cdimascio.dotenv.Dotenv;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().directory("C:/Users/MSI/Desktop/stage_formation/Microservices-SpringBoot").load();
		System.setProperty("GIT_URI", dotenv.get("GIT_URI"));
		System.setProperty("GIT_USERNAME", dotenv.get("GIT_USERNAME"));
		System.setProperty("GIT_PASSWORD", dotenv.get("GIT_PASSWORD"));
		System.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));
		System.setProperty("SPRING_APPLICATION_NAME", dotenv.get("SPRING_APPLICATION_NAME"));

		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
