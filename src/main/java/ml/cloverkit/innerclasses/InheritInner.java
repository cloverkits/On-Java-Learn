package ml.cloverkit.innerclasses;

class WithInner {
    class Inner {}
}

public class InheritInner extends WithInner.Inner {
    // InheritInner() {}
    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner inheritInner = new InheritInner(wi);
    }
}
