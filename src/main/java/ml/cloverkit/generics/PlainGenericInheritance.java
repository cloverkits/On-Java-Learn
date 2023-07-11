package ml.cloverkit.generics;

class GenericSetter<T> {    // 非自限定
    void set(T arg) {
        System.out.println("GenericSetter.set(Base");
    }
}

class DerivedGS extends GenericSetter<Base> {
    void set(Derived drived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();
        dgs.set(derived);
        dgs.set(base);  // 重载不是重写
    }
}
