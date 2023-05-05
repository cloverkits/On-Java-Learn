package ml.cloverkit.exceptions;

class A {
    String s;

    public A(String s) {
        this.s = s;
    }
}

class B {
    A a;

    public B(A a) {
        this.a = a;
    }
}

class C {
    B b;

    public C(B b) {
        this.b = b;
    }
}

public class BetterNullPointerReports {
    public static void main(String[] args) {
        C[] ca = {
                new C(new B(new A(null))),
                new C(new B(null)),
                new C(null)
        };
        for (C c : ca) {
            try {
                System.out.println(c.b.a.s);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }
}
