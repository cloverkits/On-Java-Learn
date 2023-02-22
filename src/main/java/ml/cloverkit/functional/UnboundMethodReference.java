package ml.cloverkit.functional;

import java.util.function.Function;

class X {
    String f() {
        return "x::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        // MakeString ms = X::f();
        TransformX sp = X::f;
        X x = new X();
        sp.transform(x);
        System.out.println(x.f());
    }
}
