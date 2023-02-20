package ml.cloverkit.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWordsAplhabetic {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Clove\\IdeaProjects\\OnJava8\\src\\main\\java\\ml\\cloverkit\\collections\\SetOperations.java");
        List<String> lines = Files.readAllLines(path);
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (String line : lines) {
            for (String word : line.split("\\W+")) {
                if (word.trim().length() > 0) {
                    words.add(word);
                }
            }
        }
        System.out.println(words );
    }
}
