package com.starving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}

}
