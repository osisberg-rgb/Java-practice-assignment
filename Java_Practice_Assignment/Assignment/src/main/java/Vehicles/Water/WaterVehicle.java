package Vehicles.Water;

import Vehicles.Enums.VehicleCategory;
import Vehicles.Vehicle;
import Vehicles.Water.Enums.WaterVehicleType;

public abstract class WaterVehicle extends Vehicle {

    public abstract WaterVehicleType getType();
    public abstract double getSpeed();

    public abstract int getWheelOrPropellerCount();

    public abstract double travelTime(double distance);


    @Override
    public VehicleCategory getVehicleCategory(){
        return VehicleCategory.WATER;
    };
}
