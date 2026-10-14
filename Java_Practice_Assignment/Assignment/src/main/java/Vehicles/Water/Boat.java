package Vehicles.Water;

import Vehicles.Water.Enums.WaterVehicleType;

public class Boat extends WaterVehicle{

    private final double speed;
    private final int propellers;

    public Boat(double speed, int propellers){
        if(Double.isNaN(speed) || Double.isNaN(propellers)) throw new IllegalArgumentException("No no no");
        else if(Double.isFinite(speed) || Double.isFinite(propellers)) throw new IllegalArgumentException("no no");
        else if (Double.isInfinite(speed) || Double.isInfinite(propellers)) throw new IllegalArgumentException("no");


        this.speed = speed;
        this.propellers = propellers;
    }

    public WaterVehicleType getType(){
        return WaterVehicleType.BOAT;
    };
    public double getSpeed(){
        return speed;
    };

    public int getWheelOrPropellerCount(){
        return propellers;
    };

    public double travelTime(double distance){
        return distance/speed;
    };


}
