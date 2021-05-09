package com.ranx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.ranx")
public class XdocApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdocApplication.class, args);
	}

}
