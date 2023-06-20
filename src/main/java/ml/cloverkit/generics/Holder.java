package ml.cloverkit.generics;

import java.util.Objects;

public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) {
        value = val;
    }
    public void set(T val) {
        value = val;
    }
    public T get() {
        return value;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Holder && Objects.equals(value, ((Holder) obj).value);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        // 无法向上转型
        // Holder<Fruit> Fruit = apple;
        Holder<? extends Fruit> fruit = apple;  // OK
        Fruit p = fruit.get();
        d = (Apple) fruit.get();                // 返回 Object
        try {
            Orange c =  (Orange) fruit.get();   // 无警告
        } catch (Exception e) {
            System.out.println(e);
        }
        // 无法调用 set()
        // fruit.set(new Apple());
        // 无法调用 set()
        // fruit.set(new Fruit());
        System.out.println(fruit.equals(d));    // OK
    }
}
