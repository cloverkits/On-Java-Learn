package ml.cloverkit.arrays;

import static ml.cloverkit.ArrayShow.show;

public class ArrayOptions {
    public static void main(String[] args) {
        // 对象数组
        BerylliumSphere[] a;    // 未初始化的本地变量
        BerylliumSphere[] b = new BerylliumSphere[5];

        // 数组内部的引用被自动初始化未 null:
        show("b", b);
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i =  0; i < c.length; i++)
            if (c[i] == null)   // 可以检测是否为空引用
                c[i] = new BerylliumSphere();

        // 批量初始化
        BerylliumSphere[] d = {
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere(),
        };

        // 动态批量初始化
        a = new BerylliumSphere[] {
                new BerylliumSphere(),
                new BerylliumSphere(),
        };
        // (尾部的都好不是必须的)

        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length = " + a.length);

        // 基本类型数组
        int[] e;    // 空引用
        int[] f = new int[5];

        // 数组中的基本类型自动被初始化为 0:
        show("f", f);
        int[] g = new int[4];

        for (int i = 0; i < g.length; i++)
            g[i] = i * i;
        int[] h = { 11, 47, 93 };
        // 编译错误: 变量未被初始化
        // System.out.println("e.length = " + e.length);
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[] { 1, 2 };
        System.out.println("e.length = " + e.length);
    }
}
