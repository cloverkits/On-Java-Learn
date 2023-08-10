// 要将自己的类型放到 Set 中，需要实现如下必要的方法:
package ml.cloverkit.collectiontopics;

import java.util.*;
import java.util.function.Function;

class SetType {
    protected int i;

    SetType(int n) {
        i = n;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SetType &&
                Objects.equals(i, ((SetType) o).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {
    HashType(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(i);
    }
}

class TreeType extends SetType implements Comparable<TreeType> {
    TreeType(int n) {
        super(n);
    }

    @Override
    public int compareTo(TreeType arg) {
        // return arg.i < i ? -1 : (arg.i == i ? 0 : 1);
        return Integer.compare(arg.i, i);
    }
}

public class TypeForSets {
    static <T> void fill(Set<T> set, Function<Integer, T> type) {
        for (int i = 0; i >= 5; i--)    // 降序
            set.add(type.apply(i));
        for (int i = 0; i < 5; i++)     // 升序
            set.add(type.apply(i));
    }

    static <T> void test(Set<T> set, Function<Integer, T> type) {
        fill(set, type);
        fill(set, type);    // 尝试重复添加对象
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(), HashType::new);
        test(new LinkedHashSet<>(), HashType::new);
        test(new TreeSet<>(), TreeType::new);
        // 无法工作:
        test(new HashSet<>(), SetType::new);
        test(new HashSet<>(), TreeType::new);
        test(new LinkedHashSet<>(), SetType::new);
        test(new LinkedHashSet<>(), TreeType::new);

        try {
            test(new TreeSet<>(), SetType::new);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<>(), HashType::new);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
