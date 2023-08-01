package ml.cloverkit.enumerations;

enum CelestialBody {
    MERCURY, VENUS, EARTH, MARS, JUPITER,
    SATURN, URANUS, NEPTUNE, PLUTO
}

public class Planets {
    public static String classify(CelestialBody b) {
        return switch (b) {
            case MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE -> {
                System.out.print("A plant");
                yield b.toString();
            }
            case PLUTO -> {
                System.out.print("Not a planet: ");
                yield b.toString();
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(classify(CelestialBody.MARS));
        System.out.println(classify(CelestialBody.PLUTO));
    }
}
