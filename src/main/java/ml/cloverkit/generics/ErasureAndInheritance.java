package ml.cloverkit.generics;

class GenericBase<T> {
    private T element;
    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {}

// 未产生警告
@SuppressWarnings("rawtypes")
class Derived2 extends GenericBase {}

// class Derived3 extends GenericBase<?> {}
// 奇怪的错误:
//  unexpected type
// required: class or interface without bounds

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        // 此处出现警告
        d2.set(obj);
    }
}
