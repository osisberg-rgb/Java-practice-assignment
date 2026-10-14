package instructor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainDriverTest {

    @Test
    void mainPrintsExpectedDemonstration() throws Exception {
        List<String> expected = List.of(
                "Car: category=Land, wheels/propellers=4, time=2.00 hours",
                "Bicycle: category=Land, wheels/propellers=2, time=8.00 hours",
                "Boat: category=Water, wheels/propellers=2, time=4.00 hours",
                "Sailboat: category=Water, wheels/propellers=0, time=10.00 hours"
        );

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try (PrintStream capture = new PrintStream(bytes, true, StandardCharsets.UTF_8)) {
            System.setOut(capture);
            Class.forName("Main").getMethod("main", String[].class)
                    .invoke(null, (Object) new String[0]);
        } finally {
            System.setOut(original);
        }

        assertEquals(expected, bytes.toString(StandardCharsets.UTF_8).lines().toList());
    }
}
