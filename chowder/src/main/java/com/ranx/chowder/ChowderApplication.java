package com.ranx.chowder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ranx.chowder.mapper")
public class ChowderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChowderApplication.class, args);
	}
}
