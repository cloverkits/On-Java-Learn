// 不可变对象可以对引用别名对风险免疫
package ml.cloverkit.references;

public class Immutable1 {
    private int data;

    public Immutable1(int initVal) {
        data = initVal;
    }

    public int read() {
        return data;
    }

    public boolean nonzero() {
        return data != 0;
    }

    public Immutable1 multiply(int multiplier) {
        return new Immutable1(data * multiplier);
    }

    public static void f(Immutable1 i1) {
        Immutable1 quad = i1.multiply(4);
        System.out.println("i1 = " + i1.read());
        System.out.println("quad = " + quad.read());
    }

    public static void main(String[] args) {
        Immutable1 x = new Immutable1(47);
        System.out.println("x = " + x.read());
        f(x);
        System.out.println("x = " + x.read());
    }
}
