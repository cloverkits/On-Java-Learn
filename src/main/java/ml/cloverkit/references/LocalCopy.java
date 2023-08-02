// 用 clone 创建本地副本
package ml.cloverkit.references;

class Duplo implements Cloneable {
    private int n;

    Duplo(int n) {
        this.n = n;
    }

    @Override
    public Duplo clone() {
        try {
            return (Duplo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getValue() {
        return n;
    }

    public void setValue(int n) {
        this.n = n;
    }

    public void increment() {
        n++;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

public class LocalCopy {
    public static Duplo g(Duplo v) {
        // 传递引用，修改了外部的对象
        v.increment();
        return v;
    }

    public static Duplo f(Duplo v) {
        v = v.clone(); // 本地副本
        v.increment();
        return v;
    }

    public static void main(String[] args) {
        Duplo a = new Duplo(11);
        Duplo b = g(a);
        // 引用相等，并不是对象相等:
        System.out.println("a == b: " + (a == b) + "\na = " + a + "\nb = " + b);
        Duplo c = new Duplo(47);
        Duplo d = f(c);
        System.out.println("c == d: " + (c == d) + "\nc = " + c + "\nd = " + d);
    }
}
