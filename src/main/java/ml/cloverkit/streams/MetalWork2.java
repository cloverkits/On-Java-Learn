package ml.cloverkit.streams;

import onjava.Operation;

import java.util.Arrays;

public class MetalWork2 {

    public static void main(String[] args) {
        Arrays.stream(new Operation[] {
                () -> Operation.show("Heat"),
                () -> Operation.show("Hammer"),
                () -> Operation.show("Twist"),
                () -> Operation.show("Anneal"),
        }).forEach(Operation::execute);
    }
}
