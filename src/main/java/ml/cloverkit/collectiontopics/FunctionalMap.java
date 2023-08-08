package ml.cloverkit.collectiontopics;

import java.util.Map;

import static ml.cloverkit.HTMLColors.*;

public class FunctionalMap {
    public static void main(String[] args) {
        MAP.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(v -> v.startsWith("Dark"))
                .map(v -> v.replaceFirst("Dark", "Hot"))
                .forEach(System.out::println);
    }
}
