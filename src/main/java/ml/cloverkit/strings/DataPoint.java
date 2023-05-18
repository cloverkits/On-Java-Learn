package ml.cloverkit.strings;

public class DataPoint {
    private String location;
    private Double temperature;

    public DataPoint(String location, Double temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return """
                Location: %s
                Temperature: %.2f
                """.formatted(location, temperature);
    }

    public static void main(String[] args) {
        DataPoint hill = new DataPoint("Hill", 45.2);
        DataPoint date = new DataPoint("Date", 65.2);
        System.out.print(hill);
        System.out.print(date);
    }
}
