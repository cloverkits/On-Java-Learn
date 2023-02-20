package ml.cloverkit.collections;

import onjava.Stack;

import java.util.Arrays;

public class StackTest2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Arrays.stream("My dog has fleas".split(" ")).forEach(stack::push);

        while (!stack.isEmpty())
            System.out.println(stack.pop() + " ");
    }
}
