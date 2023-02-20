package ml.cloverkit.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StackTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        Arrays.stream("My dog has fleas".split(" ")).forEach(stack::push);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
