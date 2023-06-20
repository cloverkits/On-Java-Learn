package ml.cloverkit.generics;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        // 未产生警告
        Apple a = (Apple) flist.get(0);
        // 参数是 Object
        flist.contains(new Apple());
        // 参数是 Object
        flist.indexOf(new Apple());
    }
}
