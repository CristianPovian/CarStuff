package com.lexisnexis.CarStuff.controllers;

import com.lexisnexis.CarStuff.entities.*;
import com.lexisnexis.CarStuff.repository.Repository;
import com.lexisnexis.CarStuff.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carList = carService.getCarList();
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") String id){
        Car car = carService.getCarById(id);
        if(car==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        Car car1 = carService.createCar(car);
        return ResponseEntity.ok(car1);
    }

    @PatchMapping("/cars/{id}")
    public ResponseEntity<Car> patchCar(@PathVariable("id") String id, @RequestBody Map<String,Object> toUpdate){
        Car car = carService.patchCar(id, toUpdate);
        if(car==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @DeleteMapping("/cars/{id}")
    public boolean deleteById(@PathVariable("id") String id){
        return carService.deleteCarById(id);
    }

    @DeleteMapping("/cars")
    public void deleteList(@RequestBody MultipleRequest deleteRequest){
        carService.deleteCarsById(deleteRequest.getIds());
    }

    @PostMapping("/cars/getByField")
    public ResponseEntity<List<Car>> getCarsByField(@RequestBody FieldRequest fieldRequest){
        List<Car> cars = carService.getCarsByField(fieldRequest.getFieldName(),fieldRequest.getValue());
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/cars/getByFields")
    public ResponseEntity<List<Car>> getCarsByFields(@RequestBody GenericMultipleFieldRequest<String, String> genericMultipleFieldRequest){
        List<Car> cars = carService.getCarsByFields(genericMultipleFieldRequest.getRequests());
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/cars/getByFieldsAutocomplete")
    public ResponseEntity<List<Car>> getCarsByFieldsAutocomplete(@RequestBody GenericMultipleFieldRequest<String, String> genericMultipleFieldRequest){
        List<Car> cars = carService.getCarsByFieldsAutocomplete(genericMultipleFieldRequest.getRequests());
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/cars/getCarsByFieldsMix")
    public ResponseEntity<List<Car>>  getCarsByFieldsMix(@RequestBody Mix mix){
        return ResponseEntity.ok(carService.getCarsByFieldsMix(mix));
    }

    @PostMapping("/cars/getCarsByRange")
    public ResponseEntity<List<Car>> getCarsByRange(@RequestBody GenericMultipleFieldRequest<String, Repository.Range> genericMultipleFieldRequest){
        return ResponseEntity.ok(carService.getCarsByRange(genericMultipleFieldRequest.getRequests()));
    }
}
