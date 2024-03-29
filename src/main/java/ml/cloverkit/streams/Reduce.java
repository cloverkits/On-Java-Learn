package ml.cloverkit.streams;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

class Frobnitz {
    int size;

    public Frobnitz(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Frobnitz{" +
                "size=" + size +
                '}';
    }

    static Random rand = new Random(47);
    static final int BOUND = 100;

    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}

public class Reduce {
    public static void testReduce() {
        // Create a stream of Frobnitz objects with fixed sizes
        Stream<Frobnitz> stream = Stream.of(
                new Frobnitz(58),
                new Frobnitz(55),
                new Frobnitz(93),
                new Frobnitz(61)
        );

        // Call the reduce method with the same lambda expression as in Reduce.java
        Optional<Frobnitz> result = stream.reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1);

        System.out.println(result);
    }

    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)
                .ifPresent(System.out::println);

        testReduce();
    }
}
