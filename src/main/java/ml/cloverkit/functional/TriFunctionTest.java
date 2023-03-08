package ml.cloverkit.functional;

public class TriFunctionTest {

    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::f;
        Integer apply1 = tf.apply(10, 12L, 13.1);
        System.out.println(apply1);
        tf = (i, l, d) -> (int) (i + l + d);
        Integer apply = tf.apply(1, 2L, 3.0);
        System.out.println(apply);
    }
}
