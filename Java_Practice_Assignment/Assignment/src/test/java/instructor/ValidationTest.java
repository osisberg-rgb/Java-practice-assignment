package instructor;

import Vehicles.Land.Car;
import Vehicles.Land.Bicycle;
import Vehicles.Water.Boat;
import Vehicles.Water.Sailboat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void speedsRejectInvalidValues() {
        double[] invalid = {0, -1, -0.1, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};

        for (double value : invalid) {
            assertThrows(IllegalArgumentException.class, () -> new Car(value));
            assertThrows(IllegalArgumentException.class, () -> new Bicycle(value));
            assertThrows(IllegalArgumentException.class, () -> new Boat(value, 1));
            assertThrows(IllegalArgumentException.class, () -> new Sailboat(value));
        }
    }

    @Test
    void boatRejectsNegativePropellerCounts() {
        assertThrows(IllegalArgumentException.class, () -> new Boat(20, -1));
        assertDoesNotThrow(() -> new Boat(20, 0));
        assertDoesNotThrow(() -> new Boat(20, 2));
    }

    @Test
    void travelTimeRejectsInvalidDistances() {
        Car car = new Car(60);
        for (double value : new double[]{0, -1, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}) {
            assertThrows(IllegalArgumentException.class, () -> car.travelTime(value));
        }
    }
}
