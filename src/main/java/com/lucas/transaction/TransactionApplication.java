package com.lucas.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lucas.transaction")
public class TransactionApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(TransactionApplication.class, args);
	}
}
