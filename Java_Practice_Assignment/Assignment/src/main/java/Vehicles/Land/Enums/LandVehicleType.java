package Vehicles.Land.Enums;

import Vehicles.Land.LandVehicle;

public enum LandVehicleType {
    CAR("Car", "A four-wheeled motor vehicle."),
    BICYCLE("Bicycle", "A two-wheeled human-powered vehicle.");

    private final String name;
    private final String description;

    LandVehicleType(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
