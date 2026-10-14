package Vehicles;

import Vehicles.Enums.VehicleCategory;

public abstract class Vehicle {
    public abstract int getWheelOrPropellerCount();
    public abstract VehicleCategory getVehicleCategory();
    public abstract double travelTime(double distance);
}
