package ml.cloverkit.references.tests;

import ml.cloverkit.references.DepthReading;
import ml.cloverkit.references.OceanReading;
import ml.cloverkit.references.TemperatureReading;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeepCopyTest {

    @Test
    public void testClone() {
        OceanReading reading = new OceanReading(33.9, 100.5);
        // 进行克隆
        OceanReading clone = reading.clone();
        TemperatureReading tr = clone.getTemperature();
        tr.setTemperature(tr.getTemperature() + 1);
        clone.setTemperature(tr);
        DepthReading dr = clone.getDepth();
        dr.setDepth(dr.getDepth() + 1);
        clone.setDepth(dr);
        assertEquals(reading.toString(), "temperature: 33.9, depth: 100.5");
        assertEquals(clone.toString(), "temperature: 34.9, depth: 101.5");
    }
}
