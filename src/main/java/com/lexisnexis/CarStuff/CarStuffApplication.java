package com.lexisnexis.CarStuff;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lexisnexis.CarStuff.entities.GenericMultipleFieldRequest;
import com.lexisnexis.CarStuff.repository.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class CarStuffApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(CarStuffApplication.class, args);
//		GenericMultipleFieldRequest<String, Repository.Range> nume = new GenericMultipleFieldRequest<>();
//		Map<String, Repository.Range> map = new HashMap<>();
//		map.put("mancare", new Repository.Range(1.2,5.5));
//		map.put("mancare multa", new Repository.Range(43.5,44.5));
//		nume.setRequests(map);
//		ObjectMapper objectMapper = new ObjectMapper();
//		System.out.println(objectMapper.writeValueAsString(nume));

	}


}
