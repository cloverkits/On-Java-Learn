package ml.cloverkit.enumerations;

public class SwitchExpression {
    static int colon(String s) {
        return switch (s) {
            case "i": yield 1;
            case "j": yield 2;
            case "k": yield 3;
            default:  yield 0;
        };
    }

    static int arrow(String s) {
        return switch (s) {
            case "i" -> 1;
            case "j" -> 2;
            case "k" -> 3;
            default  -> 0;
        };
    }

    public static void main(String[] args) {
        for (var s : new String[] { "i", "j", "k", "z" })
            System.out.format("%s %d %d%n", s, colon(s), arrow(s));
    }
}
