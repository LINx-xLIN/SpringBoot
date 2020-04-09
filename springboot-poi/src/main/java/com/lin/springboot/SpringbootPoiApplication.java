package com.lin.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.springboot.mapper")
public class SpringbootPoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPoiApplication.class, args);
	}

}
