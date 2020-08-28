package com.example.microservices.currencycrudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.microservices.currencycrudservice")
@EnableDiscoveryClient
public class CurrencyCrudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCrudServiceApplication.class, args);
	}

}
