package com.com.everth.bankinc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.com.everth")
public class MsBankinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBankinApplication.class, args);
		System.out.println("Hola mundo bank ink");

	}

}
