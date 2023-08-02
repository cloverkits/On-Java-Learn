package ml.cloverkit.enumerations;

sealed interface Base {}
record Derived() implements Base {}

public class Dominance {
    static String test(Base base) {
        return switch (base) {
            case Derived d -> "Derived";
            case Base b -> "B"; // 支配性如果 Base 此行上移 Derived 将永远不会执行到
        };
    }
}
