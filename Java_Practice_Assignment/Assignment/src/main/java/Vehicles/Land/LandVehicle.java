package Vehicles.Land;

import Vehicles.Enums.VehicleCategory;
import Vehicles.Land.Enums.LandVehicleType;
import Vehicles.Vehicle;

public abstract class LandVehicle extends Vehicle {


    public abstract LandVehicleType getType();

    public abstract double getSpeed();


    public abstract int getWheelOrPropellerCount();

    @Override
    public VehicleCategory getVehicleCategory(){
        return VehicleCategory.LAND;
    };

    public abstract double travelTime(double distance);

}
