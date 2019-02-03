package com.github.nicolasperuch.api.car.dto;

import javax.validation.constraints.NotNull;

public class CarDto {

    @NotNull(message = "Your car must have a brand")
    private String brand;
    @NotNull(message = "Your car must have a price")
    private Long price;
    @NotNull(message = "Your car must have a fuel comsuption information")
    private String fuelConsumption;
    @NotNull(message = "You must insert an engine type information")
    private String engineType;
    @NotNull(message = "Your car must have a size")
    private String size;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
