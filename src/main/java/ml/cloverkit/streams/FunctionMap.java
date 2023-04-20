package ml.cloverkit.streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionMap {
    static String[] elements = { "12", "", "23", "45" };

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    /**
     * Test
     *
     * @param description 描述
     * @param func Function
     */
    static void test(String description, Function<String, String> func) {
        System.out.println(" ---( " + description + " )---");
        testStream()
                .map(func)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        test("add brackets", s -> "[" + s + "]");

        test("Increment", s -> {
            try {
                return String.valueOf(Integer.parseInt(s) + 1);
            } catch (NumberFormatException e) {
                return s;
            }
        });

        test("Replace", s -> s.replace("2", "9"));

        test("Take last digit", s -> s.length() > 0 ?
                String.valueOf(s.charAt(s.length() - 1)) : s);
    }
}
