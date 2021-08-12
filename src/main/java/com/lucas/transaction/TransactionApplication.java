package com.lucas.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(TransactionApplication.class, args);
	}


}
