package instructor;

import Vehicles.Vehicle;
import Vehicles.Enums.VehicleCategory;
import Vehicles.Land.LandVehicle;
import Vehicles.Land.Enums.LandVehicleType;
import Vehicles.Water.WaterVehicle;
import Vehicles.Water.Enums.WaterVehicleType;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class AbstractContractTest {

    @Test
    void abstractHierarchyHasRequiredContracts() throws Exception {
        assertTrue(Modifier.isAbstract(Vehicle.class.getModifiers()));
        assertTrue(Modifier.isAbstract(LandVehicle.class.getModifiers()));
        assertTrue(Modifier.isAbstract(WaterVehicle.class.getModifiers()));

        assertEquals(Vehicle.class, LandVehicle.class.getSuperclass());
        assertEquals(Vehicle.class, WaterVehicle.class.getSuperclass());

        var count = Vehicle.class.getDeclaredMethod("getWheelOrPropellerCount");
        var category = Vehicle.class.getDeclaredMethod("getVehicleCategory");
        var time = Vehicle.class.getDeclaredMethod("travelTime", double.class);

        assertTrue(Modifier.isPublic(count.getModifiers()) && Modifier.isAbstract(count.getModifiers()));
        assertTrue(Modifier.isPublic(category.getModifiers()) && Modifier.isAbstract(category.getModifiers()));
        assertTrue(Modifier.isPublic(time.getModifiers()) && Modifier.isAbstract(time.getModifiers()));

        assertEquals(int.class, count.getReturnType());
        assertEquals(VehicleCategory.class, category.getReturnType());
        assertEquals(double.class, time.getReturnType());

        assertEquals(LandVehicleType.class, LandVehicle.class.getDeclaredMethod("getType").getReturnType());
        assertEquals(double.class, LandVehicle.class.getDeclaredMethod("getSpeed").getReturnType());
        assertEquals(WaterVehicleType.class, WaterVehicle.class.getDeclaredMethod("getType").getReturnType());
        assertEquals(double.class, WaterVehicle.class.getDeclaredMethod("getSpeed").getReturnType());
    }

    @Test
    void categoryMethodsBelongToIntermediateBasesAndAreFinal() throws Exception {
        var land = LandVehicle.class.getDeclaredMethod("getVehicleCategory");
        var water = WaterVehicle.class.getDeclaredMethod("getVehicleCategory");

        assertTrue(Modifier.isPublic(land.getModifiers()));
        assertTrue(Modifier.isFinal(land.getModifiers()));
        assertTrue(Modifier.isPublic(water.getModifiers()));
        assertTrue(Modifier.isFinal(water.getModifiers()));
    }
}
