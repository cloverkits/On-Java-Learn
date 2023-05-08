package ml.cloverkit.exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamsAreAutoCloseable {
    public static void main(String[] args) throws IOException, URISyntaxException {
        try (Stream<String> in = Files.lines(Paths.get("src/main/java/ml/cloverkit/exceptions/StreamsAreAutoCloseable.java"));
        PrintWriter outfile = new PrintWriter("Results.txt")) {
            in.skip(5)
                    .limit(1)
                    .map(String::toLowerCase)
                    .forEachOrdered(outfile::println);
        }
    }
}
