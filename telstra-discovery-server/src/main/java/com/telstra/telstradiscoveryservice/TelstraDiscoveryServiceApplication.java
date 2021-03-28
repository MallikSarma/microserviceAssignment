package com.telstra.telstradiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TelstraDiscoveryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TelstraDiscoveryServiceApplication.class, args);
	}

}
