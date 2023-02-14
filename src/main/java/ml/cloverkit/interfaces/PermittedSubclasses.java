package ml.cloverkit.interfaces;

import java.util.Arrays;

sealed class Color permits Red, Green, Blue {}
final class Red extends Color {}
final class Green extends Color {}
final class Blue extends Color {}

public class PermittedSubclasses {
    public static void main(String[] args) {
        Arrays.stream(Color.class.getPermittedSubclasses()).forEach(System.out::println);
    }
}
