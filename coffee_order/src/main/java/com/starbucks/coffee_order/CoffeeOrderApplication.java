package com.starbucks.coffee_order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.starbucks.coffee_order.mapper")
public class CoffeeOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeOrderApplication.class, args);
	}

}
