package ml.cloverkit.streams;

import java.util.Objects;

public class Peeking {

    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder(Objects.requireNonNull(Peeking.class.getClassLoader().getResource("Cheese.dat")).toURI())
                .stream()
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }
}
