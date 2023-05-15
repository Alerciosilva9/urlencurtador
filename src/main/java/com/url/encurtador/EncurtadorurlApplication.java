package com.url.encurtador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication()
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EncurtadorurlApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EncurtadorurlApplication.class, args);
	}

}
