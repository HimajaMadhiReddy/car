package com.ucm.car.transformer;

import com.ucm.car.model.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class DaoToDtoTransformer {
    public static Car DaoToDto(com.ucm.car.model.dao.Car car){

        Car carDto = new Car();
      carDto.setType(car.getType());
      carDto.setAvailability(car.getAvailability());
      carDto.setMake(car.getMake());
      carDto.setModel(car.getModel());
      carDto.setResourceId(car.getResourceId());
      carDto.setAddress(car.getAddress());

      return carDto;

    }

    public static List<Car> DaoListToDtoList(List<com.ucm.car.model.dao.Car> cars){

        List<Car> carsDto = new ArrayList<>();

        for ( com.ucm.car.model.dao.Car car: cars ){

           carsDto.add(DaoToDto(car));

        }
       return carsDto;
    }
}
