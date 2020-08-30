package com.lexisnexis.CarStuff.repository;

import com.lexisnexis.CarStuff.entities.Car;

import java.util.List;
import java.util.Map;

public interface Repository {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Car findById(String id);
    Car findByNumber(String nr);
    boolean updateCar(String id, Map<String, Object> updateData);
    boolean deleteCarById(String id);
}
