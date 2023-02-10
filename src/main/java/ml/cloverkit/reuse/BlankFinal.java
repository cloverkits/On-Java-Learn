package ml.cloverkit.reuse;

class Poppet {
    private int i;
    Poppet(int ii) {
        i = ii;
    }
}

public class BlankFinal {
    private final int i = 0;
    // 空白 final
    private final int j;
    // 空白 final 引用
    private final Poppet p;

    // 空白 final 字段必须在构造器里初始化
    public BlankFinal() {
        // 初始化空白 final
        j = 1;
        // 初始化空白 final 引用
        p = new Poppet(1);
    }

    public BlankFinal(int x) {
        // 初始化空白 final
        j = x;
        // 初始化空白 final 引用
        p = new Poppet(x);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
