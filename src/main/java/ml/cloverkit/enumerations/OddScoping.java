package ml.cloverkit.enumerations;

public class OddScoping {
    static void f(Object o) {
        if (! (o instanceof String s)) {
            System.out.println("No a String");
            throw new RuntimeException();
        }
        // 此处 s 仍在作用域中!
        System.out.println(s.toUpperCase());
    }

    public static void main(String[] args) {
        f("Curiouser and Curiouser");
        f(null);
    }
}
