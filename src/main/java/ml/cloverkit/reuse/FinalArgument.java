package ml.cloverkit.reuse;

class Gizmo {
    public void spin() {}
}

public class FinalArgument {
    void with(final Gizmo g) {
        // Illegal -- g is final
        // g = new Gizmo();
    }

    void without(Gizmo g) {
        // OK -- g not final
        g = new Gizmo();
        g.spin();
    }

    // 不能更改
    // void f(final int i) { i++ }

    public static void main(String[] args) {
        FinalArgument bf = new FinalArgument();
        bf.without(null);
        bf.with(null);
    }
}
