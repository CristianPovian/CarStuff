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
    List<Car> getCarsByField(String field, String value);
    List<Car> getCarsByFields(Map<String, String> requests);
    List<Car> getCarsByFieldsAutocomplete(Map<String, String> requests);
    List<Car> getCarsByFieldsMix(Map<String,String> exactFields, Map<String,String> containsString);
    List<Car> getCarsByRange(Map<String,Range> fields);

    class Range{
        public final Double minValue;
        public final Double maxValue;

        public Range(final Double minValue, final Double maxValue){
            this.minValue=minValue;
            this.maxValue=maxValue;
        }

    }
}

