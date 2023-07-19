package ml.cloverkit.arrays;

import ml.cloverkit.Rand;
import onjava.ConvertTo;

import java.util.Arrays;

public class StreamFromArray {
    public static void main(String[] args) {
        String[] s = new Rand.String().array(10);
        Arrays.stream(s)
                .skip(3)
                .limit(5)
                .map(ss -> ss + "!")
                .forEach(System.out::println);

        int[] ia = new Rand.Pint().array(10);
        Arrays.stream(ia)
                .skip(3)
                .limit(5)
                .map(i -> i * 10)
                .forEach(System.out::println);

        Arrays.stream(new long[10]);
        Arrays.stream(new double[10]);

        // 只支持 int, long 以及 double:
        // Arrays.stream(new boolean[10]);
        // Arrays.stream(new byte[10]);
        // Arrays.stream(new char[10]);
        // Arrays.stream(new short[10]);
        // Arrays.stream(new float[10]);

        // 对于其他类型，必须使用包装类
        float[] fa = new Rand.Pfloat().array(10);
        Arrays.stream(ConvertTo.boxed(fa));
        Arrays.stream(new Rand.Float().array(10));
    }
}
