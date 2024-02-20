package com.com.everth.bankinc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfigurationSource;

import com.com.everth.bankinc.cors.CorsConfig;


@SpringBootApplication
@ComponentScan("com.com.everth")
public class MsBankinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBankinApplication.class, args);
		System.out.println("Hola mundo bank ink");

	}
	
   @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfig().corsConfigurationSource();
    }

}
