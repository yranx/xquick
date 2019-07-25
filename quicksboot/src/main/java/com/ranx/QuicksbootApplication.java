package com.ranx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ranx.mapper")
public class QuicksbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuicksbootApplication.class, args);
	}

}
