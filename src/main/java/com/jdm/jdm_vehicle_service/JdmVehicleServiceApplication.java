package com.jdm.jdm_vehicle_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JdmVehicleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdmVehicleServiceApplication.class, args);
	}

}
