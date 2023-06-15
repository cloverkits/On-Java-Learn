package ml.cloverkit.generics;

class Manipulator<T> {
    private T obj;

    Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
        // Error: cannot find symbol: method f():
        // obj.f();
        System.out.println(obj.getClass().getName());
    }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
