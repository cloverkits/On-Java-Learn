package ml.cloverkit.references;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Int {
    private int i;

    Int(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
public class CloneArrayList {
    public static void main(String[] args) {
        ArrayList<Int> v = IntStream.range(0, 10)
                .mapToObj(Int::new)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("v: " + v);

        @SuppressWarnings("unchecked")
        ArrayList<Int> v2 = (ArrayList<Int>) v.clone();
        // 对 v2 中对所有元素进行自增
        v2.forEach(Int::increment);
        // 看看是否修改了 v 中的元素
        System.out.println("v: " + v);
    }
}
