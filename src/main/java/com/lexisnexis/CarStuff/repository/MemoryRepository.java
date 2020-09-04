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

    @Override
    public List<Car> getCarsByField(String field, String value) {
        return null;
    }

    @Override
    public List<Car> getCarsByFields(Map<String, String> requests) {
        return null;
    }

    @Override
    public List<Car> getCarsByFieldsAutocomplete(Map<String, String> requests) {
        return null;
    }

    @Override
    public List<Car> getCarsByFieldsMix(Map<String, String> exactFields, Map<String, String> containsString) { return null; }

    @Override
    public List<Car> getCarsByRange(Map<String,Range> fields){ return null; }
}
