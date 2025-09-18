package com.nyxses.device;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title= "Device REST API Documentation",
                description="Device management for REST API",
                version = "V1"
        )
)
@SpringBootApplication
public class DeviceManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceManageApplication.class, args);
	}

}
