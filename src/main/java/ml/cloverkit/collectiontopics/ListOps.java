package ml.cloverkit.collectiontopics;

import ml.cloverkit.HTMLColors;

import java.util.*;

public class ListOps {
    // 创建一个用于测试的短列表
    static final List<String> LIST = HTMLColors.LIST.subList(0, 10);
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        // 在位置 1 处插入
        a.add(1, "x");
        // 在末尾插入
        a.add("x");
        // 插入一个集合
        a.addAll(LIST);
        // 从位置 3 处开始，插入一个集合:
        a.addAll(3, LIST);
        // 列表中是否包含该元素?
        b = a.contains("1");
        // 作为参数的这个结合是否包含在列表中?
        b = a.containsAll(LIST);
        // List 支持随机访问，该操作对于 ArrayList 而言
        // 成本很低，但是对于 LinkedList 而言成本很高
        // 在位置 1 处获取 (有类型的) 对象
        s = a.get(1);
        // 确定对象索引
        i = a.indexOf("1");
        // 列表中是否存在元素
        b = a.isEmpty();
        // 普通的迭代器
        it = a.iterator();
        // ListIterator
        lit = a.listIterator();
        // ListIterator 从位置 3 处开始
        lit = a.listIterator(3);
        // 最后一个与参数匹配的元素的索引
        i = a.lastIndexOf("1");
        // 移除位置 1 处的元素
        a.remove(1);
        // 移除该对象
        a.remove("3");
        // 将位置 1 处的元素设置为 "y"
        a.set(1, "y");
        // 保留所有与参数中元素匹配的元素:
        // (对两个集合求交集):
        a.retainAll(LIST);
        // 移除参数中的所有元素:
        a.removeAll(LIST);
        // 这个集合多大?
        i = a.size();
        // 移除所有元素
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // 在调用 add() 之后，必须将迭代器后移:
        it.next();
        // 移除新元素后面的元素:
        it.remove();
        // 在调用 remove() 之后，必须将迭代器后移:
        it.next();
        // 修改被移除元素后面的元素:
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        System.out.println(a);
        List<String> b = LIST;
        System.out.println("b = " + b);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);
        // 使用 ListIterator
        // 插入、移除和替代元素:
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        // 反向遍历列表:
        x = a.listIterator(a.size());
        while (x.hasPrevious())
            System.out.print(x.previous() + " ");
        System.out.println();
        System.out.println("testVisual finished");
    }

    // 有些只有 LinkedList 才有的操作
    public static void testLikedList() {
        LinkedList<String> ll = new LinkedList<>();
        ll.addAll(LIST);
        System.out.println(ll);
        // 将其看作一个栈， 压栈:
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);
        // 类似于从栈顶执行的 peek 操作:
        System.out.println(ll.getFirst());
        // 类型与从栈顶弹出:
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        // 将其看作一个队列，从队尾取出元素:
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }

    public static void main(String[] args) {
        // 每次创建并填充一个新的列表:
        basicTest(new LinkedList<>(LIST));
        basicTest(new ArrayList<>(LIST));
        iterMotion(new LinkedList<>(LIST));
        iterMotion(new ArrayList<>(LIST));
        iterManipulation(new LinkedList<>(LIST));
        iterManipulation(new ArrayList<>(LIST));
        testVisual(new LinkedList<>(LIST));
        testVisual(new ArrayList<>(LIST));
        testLikedList();
    }
}
