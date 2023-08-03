package ml.cloverkit.references;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Int2 implements Cloneable {
    private int i;

    Int2(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    public Int2 clone() {
        try {
            return (Int2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // 继承不会移除可克隆性:
    static class Int3 extends Int2 {
        private int j;  // 自动创建了副本

        Int3(int i) {
            super(i);
        }
    }
}

public class AddingClone {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = x.clone();
        x.increment();
        System.out.println("x = " + x + ", x2 = " + x2);
        // 继承出得任何食物同样也是可克隆的:
        Int2.Int3 x3 = new Int2.Int3(7);
        x3 = (Int2.Int3) x3.clone();
        ArrayList<Int2> v = IntStream.range(0, 10)
                .mapToObj(Int2::new)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("v: " + v);
        ArrayList<Int2> v2 = (ArrayList<Int2>) v.clone();
        // 现在克隆每个元素:
        IntStream.range(0, v.size())
                .forEach(i -> v2.set(i, v.get(i).clone()));
        // 对 v2 的所有元素进行累加
        v2.forEach(Int2::increment);
        System.out.println("v2: " + v2);
        // 看看是否改变了 v 中的所有元素
        System.out.println("v: " + v);
    }
}
