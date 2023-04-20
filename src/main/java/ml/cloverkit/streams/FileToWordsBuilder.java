package ml.cloverkit.streams;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class FileToWordsBuilder {

    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(URI filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1)    // 跳过开头的注释行
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder(Objects.requireNonNull(FileToWordsBuilder.class.getClassLoader().getResource("Cheese.dat")).toURI()).stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
