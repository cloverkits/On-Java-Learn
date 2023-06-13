package ml.cloverkit.generics;

import ml.cloverkit.Tuple2;
import ml.cloverkit.Tuple3;
import ml.cloverkit.Tuple4;
import ml.cloverkit.Tuple5;

public class TupleTest {
    static Tuple2<String, Integer> f() {
        // 自动装箱将 int 转换成 Integer
        return new Tuple2<>("h1", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return new Tuple5<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        // Compile error: final
        // ttsi.a1 = "there";
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
