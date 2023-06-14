package ml.cloverkit.generics;

public class CountedObject {
    private static long counter = 0;
    public final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }
}
