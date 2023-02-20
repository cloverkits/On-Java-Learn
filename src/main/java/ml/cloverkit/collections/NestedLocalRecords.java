package ml.cloverkit.collections;

public class NestedLocalRecords {
    record Nested(String s) {}

    void method() {
        record Local(String s) {}
    }
}
