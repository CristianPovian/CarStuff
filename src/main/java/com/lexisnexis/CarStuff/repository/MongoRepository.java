package com.lexisnexis.CarStuff.repository;


import com.lexisnexis.CarStuff.entities.Car;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class MongoRepository implements Repository {
    private final MongoTemplate mongoTemplate;

    MongoRepository() {
        ConnectionString connString = new ConnectionString(
                "mongodb+srv://test:LnReWoJeEyclITlI@cluster0.znt7z.mongodb.net/someDbName?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();

        MongoClient mc = MongoClients.create(settings);
        mongoTemplate = new MongoTemplate(mc, "someDbName");
    }

    @Override
    public Car saveCar(Car car) {
        return mongoTemplate.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return mongoTemplate.findAll(Car.class);
    }

    @Override
    public Car findById(String id) {
        return mongoTemplate.findById(id, Car.class);
    }

    @Override
    public Car findByNumber(String nr) {
        Query query = query(where("number").is(nr));
        return mongoTemplate.findOne(query, Car.class);
    }

    @Override
    public boolean updateCar(String id, Map<String, Object> updateData) {

        Query query = query(where("id").is(id));

        Update update = new Update();

        for (Map.Entry<String, Object> entry : updateData.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }

        UpdateResult rez = mongoTemplate.updateFirst(query, update, Car.class);
//        if(rez.getModifiedCount() == 0) return false;
//        else return true;
        return rez.getModifiedCount() != 0;
    }

    @Override
    public boolean deleteCarById(String id) {
        Query query = query(where("_id").is(id));
        DeleteResult del = mongoTemplate.remove(query, Car.class);
        return del.getDeletedCount() != 0;
    }

    @Override
    public List<Car> getCarsByField(String field, String value) {
        Query query = query(where(field).is(value));
        return mongoTemplate.find(query, Car.class);
    }

    @Override
    public List<Car> getCarsByFields(Map<String, String> requests) {
        Query query = new Query();
        query = buildQueryForExactFields(query, requests);
        return mongoTemplate.find(query, Car.class);
    }

    @Override
    public List<Car> getCarsByFieldsAutocomplete(Map<String, String> requests) {
        Query query = new Query();
        query = buildQueryForContainsString(query, requests);
        return mongoTemplate.find(query, Car.class);
    }

    @Override
    public List<Car> getCarsByFieldsMix(Map<String, String> exactFields, Map<String, String> containsString) {
        Query query = new Query();
        query = buildQueryForExactFields(query, exactFields);
        query = buildQueryForContainsString(query, containsString);
        return mongoTemplate.find(query, Car.class);
    }

    @Override
    public List<Car> getCarsByRange(Map<String,Range> fields){
        Query query = new Query();

        for (Map.Entry<String,Range> entry : fields.entrySet()) {
            String key = entry.getKey();
            Range value = entry.getValue();
            Double minValue = value.minValue;
            Double maxValue = value.maxValue;
            if (minValue==null || maxValue==null || minValue>maxValue){
                continue;
            }
            query = query.addCriteria(where(key).lte(maxValue).gte(minValue));
        }
        return mongoTemplate.find(query, Car.class);
    }

    public Query buildQueryForExactFields(Query query, Map<String, String> map) {
        if (map == null) {
            return query;
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            query = query.addCriteria(where(key).is(value));
        }
        return query;
    }

    public Query buildQueryForContainsString(Query query, Map<String, String> map) {
        if (map == null) {
            return query;
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            query = query.addCriteria(where(key).regex(value));
        }
        return query;
    }

}
