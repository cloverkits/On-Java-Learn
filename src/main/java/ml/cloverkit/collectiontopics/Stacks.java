package ml.cloverkit.collectiontopics;

import java.util.LinkedList;
import java.util.Stack;

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER
}

public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (Month m : Month.values())
            stack.push(m.toString());
        System.out.println("stack = " + stack);
        // 把栈当成一个 Vector:
        stack.addElement("The last line");
        System.out.println("element 5 = " + stack.elementAt(5));
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");

        // 把 LinkedList 当成一个栈:
        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values())
            lstack.addFirst(m.toString());
        System.out.println("lstack = " + lstack);
        while (!stack.isEmpty())
            System.out.print(lstack.removeFirst() + " ");

        // 使用基础卷 12 章创建的 Stack 类
        onjava.Stack<String> stack2 = new onjava.Stack<>();
        for (Month m : Month.values())
            stack2.push(m.toString());
        System.out.println("stack2 = " + stack2);
        while (!stack2.isEmpty())
            System.out.print(stack2.pop() + " ");
    }
}
