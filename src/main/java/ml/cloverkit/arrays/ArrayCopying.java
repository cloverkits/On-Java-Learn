package ml.cloverkit.arrays;

import ml.cloverkit.ArrayShow;
import onjava.Count;

import java.util.Arrays;

import static ml.cloverkit.ArrayShow.*;

class Sup { // 父类
    private int id;

    Sup(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }
}

class Sub extends Sup { // 子类
    Sub(int n) {
        super(n);
    }
}

public class ArrayCopying {
    private static final int SZ = 15;
    public static void main(String[] args) {
        int[] a1 = new int[SZ];
        Arrays.setAll(a1, new Count.Integer()::get);
        show("a1", a1);

        int[] a2 = Arrays.copyOf(a1, a1.length);
        // 证明它们各是不同的数组:
        Arrays.fill(a1, 1);
        show("a1", a1);
        show("a2", a2);

        // 创建一个更短的数组:
        a2 = Arrays.copyOf(a2, a2.length / 2);
        show("a2", a2);
        // 分配更多空间
        a2 = Arrays.copyOf(a2, a2.length + 5);
        show("a2", a2);

        // 同样复制包装的数组:
        Integer[] a3 = new Integer[SZ];
        Arrays.setAll(a3, new Count.Integer()::get);
        Integer[] a4 = Arrays.copyOfRange(a3, 4, 12);
        show("a4", a4);

        Sub[] d = new Sub[SZ / 2];
        Arrays.setAll(d, Sub::new);
        // 由 Sub[] 生成 Sub[]:
        Sup[] b = Arrays.copyOf(d, d.length, Sup[].class);
        show(b);

        // 这里的 “向下转型” 可以生效:
        Sub[] d2 = Arrays.copyOf(b, b.length, Sub[].class);
        show(d2);

        // “向下转型“ 可以通过编译，但会抛出异常:
        Sup[] b2 = new Sup[SZ / 2];
        Arrays.setAll(b2, Sup::new);
        try {
            Sub[] d3 = Arrays.copyOf(
                    b2, b2.length, Sub[].class
            );
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
