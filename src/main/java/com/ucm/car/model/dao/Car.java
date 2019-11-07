package com.ucm.car.model.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection="cars")
public class Car {

        @Id
       private UUID resourceId;
       private String type;
        private String model;
        private String make;
        private Boolean availability;
        private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


}


