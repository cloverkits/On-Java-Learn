package ml.cloverkit.strings;

import java.util.Arrays;

public class Splitting {
    public static String knights = """
            Then, when you have found the shrubbery,
            you must cut down the mightiest tree in the
            forest...with... a herring!
            """;

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        // 参数里不一定要有正则字符
        split(" ");
        // 不是单词的字符
        split("\\W");
        // n 后面跟着一个不是单词的字符
        split("n\\W+");
    }
}
