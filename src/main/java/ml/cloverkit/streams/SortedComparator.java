package ml.cloverkit.streams;

import java.util.Comparator;
import java.util.Objects;

public class SortedComparator {
    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder(Objects.requireNonNull(SortedComparator.class.getClassLoader().getResource("Cheese.dat")).toURI())
                .stream()
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
