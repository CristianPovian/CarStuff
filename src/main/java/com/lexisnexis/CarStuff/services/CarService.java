package com.lexisnexis.CarStuff.services;

import com.lexisnexis.CarStuff.entities.Car;
import com.lexisnexis.CarStuff.repository.Repository;
import com.lexisnexis.CarStuff.repository.RepositoryFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CarService {

    Repository repository;

    public CarService(){
        repository = RepositoryFactory.getRepository(0);
    }

    public List<Car> getCarList(){
        return repository.getAllCars();
    }

    public Car getCarById(String id){
        return repository.findById(id);
    }

//    public List<Car> getSpecCar(String car) { return repository.getAllCars(); }

    public Car createCar(Car car){
        Date date = new Date();
        car.setCreatedDate(date);
        car.setLastUpdatedDate(date);
        return repository.saveCar(car);
    }

    public Car patchCar(String id, Map<String,Object> toUpdate){
        Date date = new Date();
        toUpdate.put("lastUpdatedDate", date);
        toUpdate.remove("createdDate");
        repository.updateCar(id,toUpdate);
        return repository.findById(id);
    }

    public void delCarById(String id){
        repository.deleteCarById(id);
    }

}