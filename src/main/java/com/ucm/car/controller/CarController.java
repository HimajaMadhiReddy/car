package com.ucm.car.controller;

import com.ucm.car.exception.DuplicateRecordException;
import com.ucm.car.exception.InvalidRequestException;
import com.ucm.car.exception.ResourceNotFoundException;
import com.ucm.car.model.dto.Car;

import com.ucm.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarController {


    @Autowired
    CarService carService;
    @ResponseBody
    @RequestMapping(produces = "application/json")
    List<Car> searchCar(@RequestParam(required = false) String make, @RequestParam(required = false) String type, @RequestParam(required = false) String model){

        return carService.validateSearchRequest(make, type, model);

    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    @ResponseBody
    Car createCar(@RequestBody Car car) throws InvalidRequestException, DuplicateRecordException {


    return carService.validateCreateRequest(car);
}

@ResponseBody
@RequestMapping(value = "/{resourceId}",produces = "application/json")
Car getByResourceId(@PathVariable String resourceId) throws InvalidRequestException, ResourceNotFoundException {

        return carService.getResourceId(resourceId);

}

}
