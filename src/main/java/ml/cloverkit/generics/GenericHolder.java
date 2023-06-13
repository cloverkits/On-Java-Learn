package ml.cloverkit.generics;

public class GenericHolder<T> {
    private T a;

    public GenericHolder() {
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        // 类型已检查
        h3.set(new Automobile());
        // 不需要转型
        Automobile a = h3.get();
        // Error
        // h3.set("Not an Automobie");
        // Error
        // h3.set(1);
    }
}
