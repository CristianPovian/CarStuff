package com.lexisnexis.CarStuff.repository;



import com.lexisnexis.CarStuff.entities.Car;

import java.util.List;
import java.util.Map;

public class MemoryRepository implements Repository{

    @Override
    public Car saveCar(Car car) {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public Car findById(String id) {
        return null;
    }

    @Override
    public Car findByNumber(String nr) {
        return null;
    }

    @Override
    public boolean updateCar(String id, Map<String, Object> updateData) {
        return false;
    }

    @Override
    public boolean deleteCarById(String id) {
        return false;
    }
}
