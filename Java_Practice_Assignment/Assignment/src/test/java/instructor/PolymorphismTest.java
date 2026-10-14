package instructor;

import Vehicles.Vehicle;
import Vehicles.Enums.VehicleCategory;
import Vehicles.Land.*;
import Vehicles.Land.Enums.LandVehicleType;
import Vehicles.Water.*;
import Vehicles.Water.Enums.WaterVehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolymorphismTest {

    @Test
    void vehiclesWorkThroughVehicleReferences() {
        Vehicle[] vehicles = {
                new Car(60),
                new Bicycle(15),
                new Boat(30, 2),
                new Sailboat(12)
        };

        assertEquals(2.0, vehicles[0].travelTime(120), 1e-12);
        assertEquals(8.0, vehicles[1].travelTime(120), 1e-12);
        assertEquals(4.0, vehicles[2].travelTime(120), 1e-12);
        assertEquals(10.0, vehicles[3].travelTime(120), 1e-12);

        assertEquals(VehicleCategory.LAND, vehicles[0].getVehicleCategory());
        assertEquals(VehicleCategory.WATER, vehicles[2].getVehicleCategory());

        assertEquals(4, vehicles[0].getWheelOrPropellerCount());
        assertEquals(2, vehicles[1].getWheelOrPropellerCount());
        assertEquals(2, vehicles[2].getWheelOrPropellerCount());
        assertEquals(0, vehicles[3].getWheelOrPropellerCount());
    }

    @Test
    void specializedTypesAreCorrect() {
        assertEquals(LandVehicleType.CAR, new Car(50).getType());
        assertEquals(LandVehicleType.BICYCLE, new Bicycle(10).getType());
        assertEquals(WaterVehicleType.BOAT, new Boat(20, 1).getType());
        assertEquals(WaterVehicleType.SAILBOAT, new Sailboat(8).getType());
    }

    @Test
    void sailboatReusesBoatBehavior() {
        Boat sailboat = new Sailboat(12);
        assertEquals(12, sailboat.getSpeed(), 1e-12);
        assertEquals(0, sailboat.getWheelOrPropellerCount());
        assertEquals(5, sailboat.travelTime(60), 1e-12);
    }
}
