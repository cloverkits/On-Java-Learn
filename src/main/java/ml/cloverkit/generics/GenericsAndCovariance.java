package ml.cloverkit.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        // 通配符提供了挟变的能力
        List<? extends Fruit> flist = new ArrayList<>();
        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        // 合法，但是没有意义
        flist.add(null);
        // 我们知道至少能返回 Fruit
        Fruit f = flist.get(0);
    }
}
