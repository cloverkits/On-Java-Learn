package ml.cloverkit.collections;

import java.util.Set;
import java.util.TreeSet;

public class SortedSetOfString {
    public static void main(String[] args) {
        Set<String> color = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            color.add("Yellow");
            color.add("Blue");
            color.add("Red");
            color.add("Red");
            color.add("Orange");
            color.add("Yellow");
            color.add("Blue");
            color.add("Purple");
        }
        System.out.println(color);
    }
}
