package ml.cloverkit.strings;

public class Indentation {
    public static final String NONE = """
            XXX
            YYY
            """; // 没有锁进
    public static final String TWO = """
            XXX
            YYY
          """; // 产生 2 个缩进

    public static final String EIGHT = """
            XXX
            YYY
    """;

    public static void main(String[] args) {
        System.out.print(NONE);
        System.out.print(TWO);
        System.out.print(EIGHT);
    }
}
