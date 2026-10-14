package Vehicles.Water;

import Vehicles.Water.Enums.WaterVehicleType;

public class Sailboat extends Boat{


    private final double speed;
    private static final int propellers = 0;

    public Sailboat(double speed){
        super(speed, propellers);
        this.speed = speed;

        if(Double.isNaN(speed)) throw new IllegalArgumentException("No no no");
        else if(Double.isFinite(speed)) throw new IllegalArgumentException("no no");
        else if (Double.isInfinite(speed)) throw new IllegalArgumentException("no");
    }

    @Override
    public WaterVehicleType getType(){
        return WaterVehicleType.SAILBOAT;
    };


}
