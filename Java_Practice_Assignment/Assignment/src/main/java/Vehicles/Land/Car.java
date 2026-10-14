package Vehicles.Land;

import Vehicles.Enums.VehicleCategory;
import Vehicles.Land.Enums.LandVehicleType;

public class Car extends LandVehicle{

    private final double wheel = 4;
    private final double speed;

    public Car(double speed){
        if(Double.isNaN(speed)) throw new IllegalArgumentException("No no no");
        else if(Double.isFinite(speed)) throw new IllegalArgumentException("no no");
        else if (Double.isInfinite(speed)) throw new IllegalArgumentException("no");
        this.speed = speed;
    }

    public LandVehicleType getType(){
        return LandVehicleType.CAR;
    };
    public double getSpeed(){
        return speed;
    };

    public int getWheelOrPropellerCount(){
        return 4;
    };

    public double travelTime(double distance){
        return distance/speed;
    };



}
