package com.lexisnexis.CarStuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class CarStuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarStuffApplication.class, args);

	}

}
