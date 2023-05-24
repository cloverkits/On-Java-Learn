package ml.cloverkit.reflection;

import java.util.function.Supplier;
import java.util.stream.Stream;

class ID {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }

    // 如果想要调用 getConstructor().newInstance()
    // 就需要调用一个 public 的无参构造器

    public ID() {}
}

public class DynamicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(ID.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }
}
