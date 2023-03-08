package ml.cloverkit.functional;

import java.util.function.IntSupplier;

public class AnonymousClosure {

    IntSupplier makeFun(int x) {
        int i = 0;
        // 同样的规则适用于:
        // i++; // 并非 “实际上的最终变量”
        // x++; // 同上
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
