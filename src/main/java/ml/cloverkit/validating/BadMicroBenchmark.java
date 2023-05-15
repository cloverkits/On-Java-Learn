package ml.cloverkit.validating;

import onjava.Timer;

import java.util.Arrays;

public class BadMicroBenchmark {
    static final int SIZE = 250_000_000;

    public static void main(String[] args) {
        // 对于内存不足的机器
        try {
            long[] la = new long[SIZE];
            System.out.println("setAll: " + Timer.duration(() -> Arrays.setAll(la, n -> n)));
            System.out.println("parallelSetAll: " + Timer.duration(() -> Arrays.parallelSetAll(la, n -> n)));
        } catch (OutOfMemoryError e) {
            System.out.println("Insufficient memory");
            System.exit(0);
        }
    }
}
