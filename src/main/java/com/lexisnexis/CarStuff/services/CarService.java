package com.lexisnexis.CarStuff.services;

import com.lexisnexis.CarStuff.entities.Car;
import com.lexisnexis.CarStuff.entities.GenericMultipleFieldRequest;
import com.lexisnexis.CarStuff.entities.Mix;
import com.lexisnexis.CarStuff.repository.Repository;
import com.lexisnexis.CarStuff.repository.RepositoryFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CarService {

    Repository repository;

    public CarService() {
        repository = RepositoryFactory.getRepository(0);
    }

    public List<Car> getCarList() {
        return repository.getAllCars();
    }

    public Car getCarById(String id) {
        return repository.findById(id);
    }

    public Car createCar(Car car) {
        Date date = new Date();
        car.setCreatedDate(date);
        car.setLastUpdatedDate(date);
        return repository.saveCar(car);
    }

    public Car patchCar(String id, Map<String, Object> toUpdate) {
        Date date = new Date();
        toUpdate.put("lastUpdatedDate", date);
        toUpdate.remove("createdDate");
        repository.updateCar(id, toUpdate);
        return repository.findById(id);
    }

    public boolean deleteCarById(String id) {
        return repository.deleteCarById(id);
    }

    public void deleteCarsById(List<String> id) {
        for (int i = 0; i < id.size(); i++)
            repository.deleteCarById(id.get(i));
    }

    public List<Car> getCarsByField(String field, String value) {
        return repository.getCarsByField(field, value);
    }

    public List<Car> getCarsByFields(Map<String, String> requests) {
        return repository.getCarsByFields(requests);
    }

    public List<Car> getCarsByFieldsAutocomplete(Map<String, String> requests) {
        return repository.getCarsByFieldsAutocomplete(requests);
    }

    public List<Car> getCarsByFieldsMix(Mix mix) {

        GenericMultipleFieldRequest<String, String> containsString = mix.getContainsString();
        GenericMultipleFieldRequest<String, String> exactFields = mix.getExactFields();

        if (containsString == null) {
            List<Car> cars = repository.getCarsByFields(exactFields.getRequests());
            return cars;
        }
        if (exactFields == null) {
            return repository.getCarsByFieldsAutocomplete(containsString.getRequests());
        }
        return repository.getCarsByFieldsMix(exactFields.getRequests(), containsString.getRequests());

    }

    public List<Car> getCarsByRange(Map<String, Repository.Range> fields){
        return repository.getCarsByRange(fields);
    }
}