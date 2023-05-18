package ml.cloverkit.strings;

public class TextBlocks {
    public static final String OLD =
            "Yesterday, upon the stair,\n" +
            "I met a man who wasn't there\n";

    public static final String NEW = """
            Yesterday, upon the stair,
            I met a man who wasn't there
            """;

    public static void main(String[] args) {
        System.out.println(OLD.equals(NEW));
    }
}
