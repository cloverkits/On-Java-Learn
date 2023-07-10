package ml.cloverkit.generics;

import java.util.zip.CheckedOutputStream;

// 探索通配符的意义
public class Wildcards {
    // 原始类型
    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg);
        // 这样不行，并没有 `T`
        // T t = holder.get();

        // 这样可以，但是丢失了类型信息:
        Object obj = holder.get();
    }

    // 和 rawArgs() 类似，但是会产生错误而不是警告⚠️:
    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.set(arg);

        // 这样不行，并没有 `T`
        // T t = holder.get();

        // 这样可以，但是丢失了类型信息:
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // holder.set(arg);

        return holder.get();
    }

    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.set(arg);
        T t = (T) holder.get();

        // 这样可以，但是丢失了类型信息:
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>();
        // 或者:
        raw  = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded =  new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded, lng);
        // Long r8 = exact2(bounded, lng);

        Long r9 = wildSubtype(raw, lng);
        Long r10 = wildSubtype(qualified, lng);
        // 这样可以，但是只能返回 Object
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        wildSuperType(qualified, lng);
    }
}
