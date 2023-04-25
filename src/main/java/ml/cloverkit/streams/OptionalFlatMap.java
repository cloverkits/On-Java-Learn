package ml.cloverkit.streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalFlatMap {
    static String[] elements = { "12", "", "23", "45" };

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String description, Function<String, Optional<String>> func) {
        System.out.println(" ---( " + description + " )---");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst()
                            .flatMap(func)
            );
        }
    }

    public static void main(String[] args) {

        // 如果 Optional 不为 empty, 在将其传给函数时，map() 首先会提取 Optional 中的对象
        test("Add brackets", s -> Optional.of("[" + s + "]"));

        test("Increment", s -> {
            try {
                return Optional.of(String.valueOf(Integer.parseInt(s) + 1));
            } catch (NumberFormatException e)  {
                return Optional.ofNullable(s);
            }
        });

        test("Replace", s -> Optional.of(s.replace("2", "9")));

        test("Take last digit", s -> s.length() > 0 ? Optional.of(String.valueOf(s.charAt(s.length() - 1))) : Optional.of(s));
    }
}
