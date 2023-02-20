package ml.cloverkit.collections;

import java.util.HashSet;
import java.util.Set;

public class SetOfString {
    public static void main(String[] args) {
        Set<String> color = new HashSet<>();

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
