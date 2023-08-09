package ml.cloverkit.collectiontopics;

import ml.cloverkit.Suppliers;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Government implements Supplier<String> {

    static String[] foundation = (
            "strange women lying in ponds" +
            "distributing swords is ro basics " +
            "for a system of government !"
    ).split(" ");
    private int index;

    @Override
    public String get() {
        return foundation[index++];
    }
}

public class SupplierCollectionTest {
    public static void main(String[] args) {
        // 基础卷 20 章引入的 Suppliers 类:
        Set<String> set = Suppliers.create(LinkedHashSet::new, new Government(), 15);
        System.out.println(set);
        List<String> list = Suppliers.create(LinkedList::new, new Government(), 15);
        System.out.println(list);
        list = new ArrayList<>();
        Suppliers.fill(list, new Government(), 15);
        System.out.println(list);

        // 或者使用流
        set = Arrays.stream(Government.foundation).collect(Collectors.toSet());
        System.out.println(set);
        list = Arrays.stream(Government.foundation).collect(Collectors.toList());
        System.out.println(list);
        list = Arrays.stream(Government.foundation).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(list);
        set = Arrays.stream(Government.foundation).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set);
    }
}
