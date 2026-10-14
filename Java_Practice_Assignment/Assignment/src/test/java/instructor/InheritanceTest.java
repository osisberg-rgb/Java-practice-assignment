package instructor;

import Vehicles.Land.*;
import Vehicles.Water.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InheritanceTest {

    @Test
    void classesUseRequiredDirectParents() {
        assertEquals(LandVehicle.class, Car.class.getSuperclass());
        assertEquals(LandVehicle.class, Bicycle.class.getSuperclass());
        assertEquals(WaterVehicle.class, Boat.class.getSuperclass());
        assertEquals(Boat.class, Sailboat.class.getSuperclass());
    }

    @Test
    void concreteClassesArePublicAndStoreOnlyPrivateFinalInstanceData() {
        for (Class<?> type : new Class<?>[]{Car.class, Bicycle.class, Boat.class, Sailboat.class}) {
            assertTrue(Modifier.isPublic(type.getModifiers()));
            assertFalse(Modifier.isAbstract(type.getModifiers()));

            for (Class<?> current = type; current != Object.class; current = current.getSuperclass()) {
                Arrays.stream(current.getDeclaredFields())
                        .filter(f -> !f.isSynthetic() && !Modifier.isStatic(f.getModifiers()))
                        .forEach(f -> {
                            assertTrue(Modifier.isPrivate(f.getModifiers()), f.getName());
                            assertTrue(Modifier.isFinal(f.getModifiers()), f.getName());
                        });
            }
        }
    }

    @Test
    void constructorsHaveExpectedParameters() throws Exception {
        assertNotNull(Car.class.getConstructor(double.class));
        assertNotNull(Bicycle.class.getConstructor(double.class));
        assertNotNull(Boat.class.getConstructor(double.class, int.class));
        assertNotNull(Sailboat.class.getConstructor(double.class));
    }
}
