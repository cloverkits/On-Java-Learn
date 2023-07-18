package ml.cloverkit.arrays;

import ml.cloverkit.Rand;

import java.util.Arrays;
import java.util.stream.Stream;

import static ml.cloverkit.ArrayShow.show;

public class TestRand {
    static final int SZ = 5;

    public static void main(String[] args) {
        System.out.println("Boolean");
        Boolean[] a1 = new Boolean[SZ];
        Arrays.setAll(a1, new Rand.Boolean()::get);
        show(a1);
        a1 = Stream.generate(new Rand.Boolean())
                .limit(SZ + 1).toArray(Boolean[]::new);
        show(a1);
        a1 = new Rand.Boolean().array(SZ + 2);
        show(a1);
        boolean[] a1b = new Rand.Pboolean().array(SZ + 3);
        show(a1b);

        System.out.println("Byte");
        Byte[] a2 = new Byte[SZ];
        Arrays.setAll(a2, new Rand.Byte()::get);
        show(a2);
        a2 = Stream.generate(new Rand.Byte())
                .limit(SZ + 1).toArray(Byte[]::new);
        show(a2);
        a2 = new Rand.Byte().array(SZ + 2);
        show(a2);
        byte[] a2b = new Rand.Pbyte().array(SZ + 3);
        show(a2b);

        System.out.println("Character");
        Character[] a3 = new Character[SZ];
        Arrays.setAll(a3, new Rand.Character()::get);
        show(a3);
        a3 = Stream.generate(new Rand.Character())
                .limit(SZ + 1).toArray(Character[]::new);
        show(a3);
        a3 = new Rand.Character().array(SZ + 2);
        show(a3);
        char[] a3b = new Rand.Pchar().array(SZ + 3);
        show(a3b);

        System.out.println("Short");
        Short[] a4 = new Short[SZ];
        Arrays.setAll(a4, new Rand.Short()::get);
        show(a4);
        a4 = Stream.generate(new Rand.Short())
                .limit(SZ + 1).toArray(Short[]::new);
        show(a4);
        a4 = new Rand.Short().array(SZ + 2);
        show(a4);
        short[] a4b = new Rand.Pshort().array(SZ + 3);
        show(a4b);

        System.out.println("Integer");
        Integer[] a5 = new Integer[SZ];
        Arrays.setAll(a5, new Rand.Integer()::get);
        show(a5);
        a5 = Stream.generate(new Rand.Integer())
                .limit(SZ + 1).toArray(Integer[]::new);
        show(a5);
        a5 = new Rand.Integer().array(SZ + 2);
        show(a5);
        int[] a5b = new Rand.Pint().array(SZ + 3);
        show(a5b);

        System.out.println("Long");
        Long[] a6 = new Long[SZ];
        Arrays.setAll(a6, new Rand.Long()::get);
        show(a6);
        a6 = Stream.generate(new Rand.Long())
                .limit(SZ + 1).toArray(Long[]::new);
        show(a6);
        a6 = new Rand.Long().array(SZ + 2);
        show(a6);
        long[] a6b = new Rand.Plong().array(SZ + 3);
        show(a6b);

        System.out.println("Float");
        Float[] a7 = new Float[SZ];
        Arrays.setAll(a7, new Rand.Float()::get);
        show(a7);
        a7 = Stream.generate(new Rand.Float())
                .limit(SZ + 1).toArray(Float[]::new);
        show(a7);
        a7 = new Rand.Float().array(SZ + 2);
        show(a7);
        float[] a7b = new Rand.Pfloat().array(SZ + 3);
        show(a7b);

        System.out.println("Double");
        Double[] a8 = new Double[SZ];
        Arrays.setAll(a8, new Rand.Double()::get);
        show(a8);
        a8 = Stream.generate(new Rand.Double())
                .limit(SZ + 1).toArray(Double[]::new);
        show(a8);
        a8 = new Rand.Double().array(SZ + 2);
        show(a8);
        double[] a8b = new Rand.Pdouble().array(SZ + 3);
        show(a8b);

        System.out.println("Double");
        String[] a9 = new String[SZ];
        Arrays.setAll(a9, new Rand.String()::get);
        show(a9);
        a9 = Stream.generate(new Rand.String())
                .limit(SZ + 1).toArray(String[]::new);
        show(a9);
        a9 = new Rand.String().array(SZ + 2);
        show(a9);
        String[] a9b = new Rand.String().array(SZ + 3);
        show(a9b);
    }
}
