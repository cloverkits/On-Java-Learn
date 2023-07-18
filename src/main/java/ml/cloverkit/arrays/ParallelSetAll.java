package ml.cloverkit.arrays;

import ml.cloverkit.Rand;

import java.util.Arrays;

public class ParallelSetAll {
    static final int SIZE = 10_000_000;

    static void intArray() {
        int[] ia = new int[SIZE];
        Arrays.setAll(ia, new Rand.Pint()::get);
        Arrays.parallelSetAll(ia, new Rand.Pint()::get);
    }

    static void longArray() {
        long[] ia = new long[SIZE];
        Arrays.setAll(ia, new Rand.Plong()::get);
        Arrays.parallelSetAll(ia, new Rand.Plong()::get);
    }

    public static void main(String[] args) {
        intArray();
        longArray();
    }
}
