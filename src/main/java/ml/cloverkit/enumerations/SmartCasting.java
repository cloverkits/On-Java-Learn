package ml.cloverkit.enumerations;

public class SmartCasting {
    static void dumb(Object x) {
        if (x instanceof String) {
            String s = (String) x;
            if (s.length() > 0) {
                System.out.format("%d %s%n", s.length(), s.toUpperCase());
            }
        }
    }

    static void smart(Object x) {
        if (x instanceof String s && s.length() > 0) {
            System.out.format("%d %s%n", s.length(), s.toUpperCase());
        }
    }

    static void wrong(Object x) {
        // "||" 永远不会生效
        // if (x instanceof String s || s.length() > 0) {}
    }

    public static void main(String[] args) {
        dumb("dumb");
        smart("smart");
    }
}
