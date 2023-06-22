package com.eureka.serer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SererApplication {
	public static void main(String[] args) {
		SpringApplication.run(SererApplication.class, args);
	}

}
