package ml.cloverkit.streams;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(URI fileUri) throws Exception {
        all = Files.lines(Paths.get(fileUri))
                .skip(1)    // 跳过第一行的注释信息
                .collect(Collectors.joining(" "));
    }

    public Stream<String> steam() {
        return Pattern.compile("[ .,?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws Exception {
        FileToWordsRegexp fw = new FileToWordsRegexp(Objects.requireNonNull(FileToWordsRegexp.class.getClassLoader().getResource("Cheese.dat")).toURI());
        fw.steam()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
        fw.steam()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
