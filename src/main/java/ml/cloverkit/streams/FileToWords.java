package ml.cloverkit.streams;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileToWords {
    public static Stream<String> stream(URI fileUri) throws IOException {
        return Files.lines(Paths.get(fileUri))
                .skip(1)    // 跳过第一行的注释信息
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));
    }
}
