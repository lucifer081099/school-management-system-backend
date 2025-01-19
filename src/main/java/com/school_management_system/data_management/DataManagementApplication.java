package com.school_management_system.data_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.school_management_system.data_management")
@ComponentScan(basePackages = "com.school_management_system.data_management")
public class DataManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataManagementApplication.class, args);
	}

}
