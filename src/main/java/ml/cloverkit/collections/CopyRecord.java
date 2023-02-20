package ml.cloverkit.collections;

record R(int a, double b, char c) implements Cloneable{

    @Override
    protected R clone() {
        try {
            return (R) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class CopyRecord {
    public static void main(String[] args) {
        R r1 = new R(11, 2.2, 'z');
        R r2 = new R(r1.a(), r1.b(), r1.c());
        R r3 = r1.clone();
        System.out.println(r1.equals(r2));
        System.out.println(r2.equals(r3));
    }
}
