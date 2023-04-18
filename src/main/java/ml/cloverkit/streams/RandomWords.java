package ml.cloverkit.streams;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(URI fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        // 跳过第一行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+")) {
                words.add(word.toLowerCase());
            }
        }
    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return String.join(" ", words);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                Stream.generate(new RandomWords(Objects.requireNonNull(RandomWords.class.getClassLoader().getResource("Cheese.dat")).toURI()))
                        .limit(10)
                        .collect(Collectors.joining(" "))
        );
    }
}
