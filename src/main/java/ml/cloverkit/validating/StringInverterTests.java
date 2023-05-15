package ml.cloverkit.validating;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringInverterTests {
    StringInverter inverter = new Inverter4();

    @BeforeAll
    static void startMsg() {
        System.out.println(">>> StringInverterTests <<<");
    }

    @Test
    void basicInversion1() {
        String in = "Exit, Pursued by a Bear.";
        String out = "eXIT, pURSUED BY A bEAR";
        assertEquals(inverter.invert(in), out);
    }

    @Test
    void basicInversion2() {
        assertThrows(Error.class, () -> {
            assertEquals(inverter.invert("X"), "X");
        });
    }

    // ...
}
