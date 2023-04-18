package ml.cloverkit.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator implements Supplier<String> {

    Random rand = new Random(47);
    char[] letters = "ABCDEFGHJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        return String.valueOf(letters[rand.nextInt(letters.length)]);
    }

    public static void main(String[] args) {
        String word = Stream.generate(new Generator())
                .limit(30)
                .collect(Collectors.joining());
        System.out.println(word);
    }
}
