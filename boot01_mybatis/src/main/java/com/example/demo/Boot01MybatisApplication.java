package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.demo.**.mapper")
@SpringBootApplication
public class Boot01MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot01MybatisApplication.class, args);
	}

}
