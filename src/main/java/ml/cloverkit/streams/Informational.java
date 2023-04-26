package ml.cloverkit.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

public class Informational {

    public static Stream<String> getStream() throws URISyntaxException, IOException {
        return FileToWords.stream(Informational.class.getClassLoader().getResource("Cheese.dat").toURI());
    }
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println(getStream().count());
        System.out.println(getStream().min(String.CASE_INSENSITIVE_ORDER).orElse("NONE"));
        System.out.println(getStream().max(String.CASE_INSENSITIVE_ORDER).orElse("NONE"));
    }
}
