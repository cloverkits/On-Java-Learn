package ml.cloverkit.validating;

import onjava.Timer;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

public class BadMicroBenchmark2 {
    // 减少了 SIZE 的值来运行的更快一点
    static final int SIZE = 5_000_000;
    public static void main(String[] args) {
        long[] la = new long[SIZE];
        Random r = new Random();
        System.out.println("parallelSetAll: " + Timer.duration(() -> Arrays.parallelSetAll(la, n -> r.nextLong())));
        System.out.println("setAll: " + Timer.duration(() -> Arrays.setAll(la, n -> r.nextLong())));

        SplittableRandom sr = new SplittableRandom();
        System.out.println("parallelSetAll: " + Timer.duration(() -> Arrays.parallelSetAll(la, n -> sr.nextLong())));
        System.out.println("setAll: " + Timer.duration(() -> Arrays.setAll(la, n -> sr.nextLong())));
    }
}
