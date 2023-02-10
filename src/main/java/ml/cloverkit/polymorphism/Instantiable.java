package ml.cloverkit.polymorphism;

abstract class UnInstantiable {
    abstract void f();
    abstract int g();
}
public class Instantiable extends UnInstantiable {

    @Override
    void f() {

    }

    @Override
    int g() {
        return 22;
    }

    public static void main(String[] args) {
        Instantiable ui = new Instantiable();
    }
}
