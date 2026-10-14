package Vehicles.Water.Enums;

public enum WaterVehicleType {
    BOAT("Boat", "A powered water vehicle."),
    SAILBOAT("Sailboat", "A boat primarily propelled by sails.");

    private final String name;
    private final String description;

    WaterVehicleType(String name, String description){
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
