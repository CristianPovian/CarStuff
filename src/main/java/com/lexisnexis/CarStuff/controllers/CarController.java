package com.lexisnexis.CarStuff.controllers;

import com.lexisnexis.CarStuff.entities.Car;
import com.lexisnexis.CarStuff.operations.FileOps;
import com.lexisnexis.CarStuff.repository.Repository;
import com.lexisnexis.CarStuff.repository.RepositoryFactory;
import com.lexisnexis.CarStuff.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

//    @GetMapping("cars/{id}")
//    public ResponseEntity<List<Car>> getSpecificCars(@PathVariable String car){
//        List<Car> carList = carService.getSpecCar(car);
//        return  ResponseEntity.ok(carList);
//    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable("id") String id){
        Car car = carService.getCarById(id);
        return car;
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car){
        Car car1 = carService.createCar(car);
        return car1;
    }

    @PatchMapping("/cars/{id}")
    public Car patchCar(@PathVariable("id") String id, @RequestBody Map<String,Object> toUpdate){
        Car car = carService.patchCar(id, toUpdate);
        return car;
    }

    @DeleteMapping("/cars/{id}")
    public void delCarById(@PathVariable("id") String id){
        carService.delCarById(id);
    }

    //TODO: delete dupa ID, delete dupa o lista de iduri :')
    //TODO: endpoint prin care un get mai specific dupa oricare camp
}
