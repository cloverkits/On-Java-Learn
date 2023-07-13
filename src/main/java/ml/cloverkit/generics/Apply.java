package ml.cloverkit.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Apply {
    public static <T, S extends Iterable<T>> void apply(S seq, Method f, Object... args) {
        try {
            for (T t: seq)
                f.invoke(t, args);
        } catch (IllegalAccessException |
                IllegalArgumentException |
                InvocationTargetException e) {
            // 失败是由程序员造成的错误
            throw new RuntimeException(e);
        }
    }
}
