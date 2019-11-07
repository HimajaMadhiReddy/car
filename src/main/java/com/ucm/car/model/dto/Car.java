package com.ucm.car.model.dto;

import java.util.UUID;

public class Car {

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
