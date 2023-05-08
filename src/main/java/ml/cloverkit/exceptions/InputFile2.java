package ml.cloverkit.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputFile2 {
    private final String fileName;

    public InputFile2(String fileName) {
        this.fileName = fileName;
    }

    public Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fileName));
    }

    public static void main(String[] args) throws IOException {
        new InputFile2("ml/cloverkit/exceptions/InputFile2.java").getLines()
                .skip(15)
                .limit(1)
                .forEach(System.out::println);
    }
}
