package ml.cloverkit.reuse;

class WithFinals {
    // 和不使用 final 没有什么区别
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    // 自动就是 final 的：
    private void g() {
        System.out.println("WithFinal.g()");
    }
}

class OverridingPrivate extends WithFinals {

    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }

    public void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // 向上转型
        OverridingPrivate op = op2;
        // op.f();
        // op.g();
        WithFinals wf = op2;
        // wf.f();
        // wf.g();
    }
}
