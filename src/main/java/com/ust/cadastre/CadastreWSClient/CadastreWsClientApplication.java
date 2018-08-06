package com.ust.cadastre.CadastreWSClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CadastreWsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastreWsClientApplication.class, args);
	}
}
