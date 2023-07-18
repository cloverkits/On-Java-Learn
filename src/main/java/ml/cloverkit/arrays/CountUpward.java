package ml.cloverkit.arrays;

import java.util.stream.LongStream;

import static ml.cloverkit.ArrayShow.show;

public class CountUpward {
    static long[] fillCounted(int size) {
        return LongStream.iterate(0, i -> i + 1)
                .limit(size).toArray();
    }

    public static void main(String[] args) {
        long[] l1 = fillCounted(20);    // 没问题
        show(l1);
        // OOM
        // long[] l2 = fillCounted(10_000_000_00);
    }
}
