package com.ucm.car.repository;

import com.ucm.car.model.dao.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findCarsByMakeAndModelAndTypeIgnoreCase ( String make, String model, String type);
    List<Car> findCarsByModelIgnoreCase ( String model);
    List<Car> findCarsByTypeIgnoreCase ( String type);
    List<Car> findCarsByMakeAndModelIgnoreCase ( String make, String model);
    List<Car> findCarsByMakeAndTypeIgnoreCase ( String make, String type);
    List<Car> findCarsByModelAndTypeIgnoreCase ( String model, String type);
    List<Car> findCarsByMakeIgnoreCase ( String make);
    Car findCarByResourceId(UUID resourceId);


}
