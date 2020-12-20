package com.alan.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author alan
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.alan.pms.mapper")
@EnableScheduling
public class PmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsWebApplication.class, args);
	}

}
