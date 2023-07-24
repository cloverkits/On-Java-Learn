package ml.cloverkit;

import java.util.SplittableRandom;

public class Enums {
    private static SplittableRandom rand = new SplittableRandom(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
