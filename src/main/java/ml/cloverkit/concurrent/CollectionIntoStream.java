package ml.cloverkit.concurrent;

import ml.cloverkit.Rand;

import java.util.List;
import java.util.stream.Stream;

public class CollectionIntoStream {
    public static void main(String[] args) {
        List<String> strings = Stream.generate(new Rand.String(5))
                .limit(10)
                .toList();
        strings.forEach(System.out::println);
        // 转换为 Stream， 以执行更多操作:
        String result = strings.stream()
                .map(String::toUpperCase)
                .map(s -> s.substring(2))
                .reduce(":", (s1, s2) -> s1 + s2);
        System.out.println(result);
    }
}
