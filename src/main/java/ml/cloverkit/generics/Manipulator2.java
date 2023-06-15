package ml.cloverkit.generics;

public class Manipulator2<T extends HasF> {
    private T obj;

    Manipulator2(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}
