package com.currency.app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException {
		
		SpringApplication.run(App.class, args);
	}

}
