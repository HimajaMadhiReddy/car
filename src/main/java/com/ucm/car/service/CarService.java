package com.ucm.car.service;

import com.ucm.car.exception.DuplicateRecordException;
import com.ucm.car.exception.InvalidRequestException;

import com.ucm.car.exception.ResourceNotFoundException;
import com.ucm.car.model.dto.Car;
import com.ucm.car.repository.CarRepository;
import com.ucm.car.transformer.DaoToDtoTransformer;
import com.ucm.car.transformer.DtoToDaoTransformer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class CarService {

    @Autowired
    CarRepository carRepository;
    public Car validateCreateRequest(com.ucm.car.model.dto.Car car) throws InvalidRequestException, DuplicateRecordException {


        car.setResourceId(UUID.randomUUID());
        return DaoToDtoTransformer.DaoToDto(carRepository.save(DtoToDaoTransformer.DtoToDao(car)));

    }

    public List<Car> validateSearchRequest(String make, String type , String model){

        List<com.ucm.car.model.dao.Car> cars = new ArrayList<>();

        if(!StringUtils.isBlank(make) && StringUtils.isBlank(model) && StringUtils.isBlank(type)){

             cars = carRepository.findCarsByMakeIgnoreCase(make);

        }
        if (!StringUtils.isBlank(model) && StringUtils.isBlank(make)&& StringUtils.isBlank(type)){
             cars = carRepository.findCarsByModelIgnoreCase(model);

        }

        if (!StringUtils.isBlank(type) && StringUtils.isBlank(make)&& StringUtils.isBlank(model)){

             cars = carRepository.findCarsByTypeIgnoreCase(type);

        }
        if (!StringUtils.isBlank(make)&& !StringUtils.isBlank(model) && StringUtils.isBlank(type)){

             cars = carRepository.findCarsByMakeAndModelIgnoreCase(make, model);
        }
        if (!StringUtils.isBlank(make)&& !StringUtils.isBlank(type) && StringUtils.isBlank(model)){

            cars = carRepository.findCarsByMakeAndTypeIgnoreCase(make, type);
        }
        if (!StringUtils.isBlank(model)&& !StringUtils.isBlank(type) && StringUtils.isBlank(make)){

            cars = carRepository.findCarsByModelAndTypeIgnoreCase(model, type);

        }
        if (!StringUtils.isBlank(model)&& !StringUtils.isBlank(model)&& !StringUtils.isBlank(type)){

            cars = carRepository.findCarsByMakeAndModelAndTypeIgnoreCase(make, model, type);

        }

        return DaoToDtoTransformer.DaoListToDtoList(cars);



    }


    public Car getResourceId( String resourceId) throws InvalidRequestException, ResourceNotFoundException {

        try{
            UUID.fromString(resourceId);
        }catch (Exception ex){
            throw new InvalidRequestException("Please enter valid resourceId "+resourceId+" entered is Invalid.");
        }

        com.ucm.car.model.dao.Car carDao = carRepository.findCarByResourceId(UUID.fromString(resourceId));

        if(carDao == null){
            throw new ResourceNotFoundException("car with given resourceId " + resourceId+ " doesn't exist");
        }
         return DaoToDtoTransformer.DaoToDto(carDao);
    }
}
