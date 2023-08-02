package ml.cloverkit.enumerations;

import java.util.List;

sealed interface Transport {}
record BiCycle(String id) implements Transport {}
record Glider(int size) implements Transport {}
record Surfboard(double weight) implements Transport {}

// 如果取消下面这行的注释:
// record Skis(int length) implements Transport {}
// 便会得到错误消息 "switch 表达式未能覆盖所有可能的输入值"

public class SealedPatternMatch {
    static String exhaustive(Transport t) {
        return switch (t) {
            case BiCycle b -> "Bicycle " + b.id();
            case Glider g -> "Glider " + g.size();
            case Surfboard s -> "Surfboard " + s.weight();
        };
    }

    public static void main(String[] args) {
        List.of(
                new BiCycle("Bob"),
                new Glider(65),
                new Surfboard(6.4)
        ).forEach(t -> System.out.println(exhaustive(t)));
        try {
            exhaustive(null); // 永远可能发生!
        } catch (NullPointerException e) {
            System.out.println("Not exhaustive: " + e);
        }
    }
}
