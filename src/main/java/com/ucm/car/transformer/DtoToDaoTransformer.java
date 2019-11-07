package com.ucm.car.transformer;

import com.ucm.car.model.dao.Car;

public class DtoToDaoTransformer {
    public static Car DtoToDao(com.ucm.car.model.dto.Car car){
        Car carDao = new Car();
        carDao.setType(car.getType());
        carDao.setModel(car.getModel());
        carDao.setAvailability(car.getAvailability());
        carDao.setResourceId(car.getResourceId());
        carDao.setMake(car.getMake());
        carDao.setAddress(car.getAddress());
        return carDao;
    }
}
