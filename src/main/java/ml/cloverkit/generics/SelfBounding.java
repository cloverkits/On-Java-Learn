package ml.cloverkit.generics;

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {}
class B extends SelfBounded<B> {}  // 这样也可以

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {}
// 不能这样做
// class E extends SelfBounding<D> {}

// 你可以这样做，所以你无法强制使用这种用法
class F extends SelfBounded {}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}