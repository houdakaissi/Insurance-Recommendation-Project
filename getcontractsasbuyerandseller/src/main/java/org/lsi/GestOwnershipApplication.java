package org.lsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "org.lsi")
public class GestOwnershipApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestOwnershipApplication.class, args);
	}
}
