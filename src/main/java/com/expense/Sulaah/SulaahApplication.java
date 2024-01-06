package com.expense.Sulaah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SulaahApplication {
	public static void main(String[] args) {
		SpringApplication.run(SulaahApplication.class, args);
	}

}
