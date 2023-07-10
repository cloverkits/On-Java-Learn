package ml.cloverkit.generics;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);     // 用捕获的类型来调用方法
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>(1);

        f1(raw);
        f2(raw);

        Holder rawBasic = new Holder();
        rawBasic.set(new Object());

        f2(rawBasic);   // 不产生警告
        // 向上转型为 Holder<?>，仍可判断出具体类型
        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
    }
}
