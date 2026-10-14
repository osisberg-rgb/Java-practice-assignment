import Vehicles.Vehicle;
import Vehicles.Land.Car;
import Vehicles.Land.Bicycle;
import Vehicles.Water.Boat;
import Vehicles.Water.Sailboat;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(60),
                new Bicycle(15),
                new Boat(30, 2),
                new Sailboat(12)
        };

        double distance = 120;

        for (Vehicle vehicle : vehicles) {
            System.out.printf(java.util.Locale.ROOT,
                    "%s: category=%s, wheels/propellers=%d, time=%.2f hours%n",
                    vehicle.getClass().getSimpleName(),
                    vehicle.getVehicleCategory(),
                    vehicle.getWheelOrPropellerCount(),
                    vehicle.travelTime(distance));
        }
    }
}
