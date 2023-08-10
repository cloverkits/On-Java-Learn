package ml.cloverkit.collectiontopics;

import java.util.*;

public class Unsupported {
    static void check(String description, Runnable tst) {
        try {
            tst.run();
        } catch (Exception e) {
            System.out.println(description + "(): " + e);
        }
    }

    static void test(String msg, List<String> list){
        System.out.println("--- " + msg + " ---");;
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        // subList 的副本
        Collection<String> c2 = new ArrayList<>(subList);
        check("retainALl", () -> c.retainAll(c2));
        check("removeAll", () -> c.removeAll(c2));
        check("clear", () -> c.clear());
        check("add", () -> c.add("X"));
        check("addAll", () -> c.addAll(c2));
        check("remove", () -> c.remove("C"));
        // List.set() 方法修改了值，但是没有没有改变该数组的大小:
        check("List.set", () -> list.set(0, "X"));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Array.asList()", list);
        test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<>(list)));
    }
}
