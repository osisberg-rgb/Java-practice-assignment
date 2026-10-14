package Vehicles.Land;

import Vehicles.Enums.VehicleCategory;
import Vehicles.Land.Enums.LandVehicleType;

public class Bicycle extends LandVehicle{

    private final double speed;
//Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY
    public Bicycle(double speed){
        if(Double.isNaN(speed)) throw new IllegalArgumentException("No no no");
        else if(Double.isFinite(speed)) throw new IllegalArgumentException("no no");
        else if (Double.isInfinite(speed)) throw new IllegalArgumentException("no");

        this.speed = speed;
    }

    @Override
    public LandVehicleType getType(){
        return LandVehicleType.BICYCLE;
    };

    public double getSpeed(){
        return speed;
    };


    public int getWheelOrPropellerCount(){
        return 2;
    };


    public double travelTime(double distance){
        return distance/speed;
    };



}

