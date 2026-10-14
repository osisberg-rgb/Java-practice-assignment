package Vehicles.Enums;

public enum VehicleCategory {
    LAND("Land", "A vehicle designed primarily for travel on land."),
    WATER("Water", "A vehicle designed primarily for travel on water.");

    private final String name;
    private final String description;

    VehicleCategory(String name, String description){
        this.name = name();
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
