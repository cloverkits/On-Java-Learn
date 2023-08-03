package ml.cloverkit.references;

public class OceanReading implements Cloneable {
    private DepthReading depth;
    private TemperatureReading temperature;

    public OceanReading(double tdata, double ddata) {
        temperature = new TemperatureReading(tdata);
        depth = new DepthReading(ddata);
    }

    @Override
    public OceanReading clone() {
        OceanReading or = null;
        try {
            or = (OceanReading) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        // 必须克隆引用
        or.depth = (DepthReading) or.depth.clone();
        or.temperature = (TemperatureReading) or.temperature.clone();
        return or;
    }

    public TemperatureReading getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureReading temperature) {
        this.temperature = temperature;
    }

    public DepthReading getDepth() {
        return depth;
    }

    public void setDepth(DepthReading depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "temperature: " + temperature + ", depth: " + depth;
    }
}
