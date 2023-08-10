// 我们可以在 Collection 上做的所有操作
package ml.cloverkit.collectiontopics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static ml.cloverkit.HTMLColors.*;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>(LIST.subList(0, 4));
        c.add("ten");
        c.add("eleven");
        show(c);
        border();
        // 从 List 创建一个数组:
        Object[] array = c.toArray();
        // 从 List 创建一个 String 数组
        String[] str = c.toArray(new String[0]);
        // 寻找最大和最小元素，这意味着
        // 不同之处取决于 Comparable 接口
        // 是如何实现的:
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));
        border();
        // 将一个集合添加到另一个集合中
        Collection<String> c2 = new ArrayList<>(LIST.subList(10, 14));
        c.addAll(c2);
        show(c);
        border();
        c.remove(LIST.get(0));
        show(c);
        border();
        // 移除包含在参数所指向集合中的所有元素:
        c.removeAll(c2);
        show(c);
        border();
        c.addAll(c2);
        show(c);
        border();
        // 某个元素是不是在该集合中?
        String val = LIST.get(3);
        System.out.println("c.contains(" + val + ") = " + c.contains(val));
        // 某个集合是不是在该集合中?
        System.out.println("c.containsAll(c2) = " + c.containsAll(c2));

        Collection<String> c3 = ((List<String>) c).subList(3, 5);
        // 保留同时存在 c2 和 c3 中的所有元素
        // (集合的交集):
        c2.retainAll(c3);
        show(c2);
        // 移除 c2 中所有 c3 出现过的元素:
        c2.removeAll(c3);
        show(c2);
        System.out.println("c2.isEmpty() = " + c2.isEmpty());
        border();
        // 函数式操作:
        c = new ArrayList<>(LIST);
        c.removeIf(s -> !s.startsWith("P"));
        c.removeIf(s -> s.startsWith("Pale"));
        // 流操作:
        c.stream().forEach(System.out::println);
        c.clear(); // 移除所有元素
        System.out.println("after c.clear():" + c);
    }
}
