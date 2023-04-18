package ml.cloverkit.streams;

import java.util.stream.Stream;

public class Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .skip(20)           // 不使用前 20 个
                .limit(10)     // 然后从中取 10 个
                .forEach(System.out::println);
    }
}
