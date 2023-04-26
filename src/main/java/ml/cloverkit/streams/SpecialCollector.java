package ml.cloverkit.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class SpecialCollector {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> words = FileToWords.stream(SpecialCollector.class.getClassLoader().getResource("Cheese.dat").toURI())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        words.stream()
                .filter(s -> s.equals("cheese"))
                .forEach(System.out::println);
    }
}
