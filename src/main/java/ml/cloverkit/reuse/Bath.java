package ml.cloverkit.reuse;

class Soap {
    private String s;

    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Bath {
    // 在定义时初始化
    private String s1 = "Happy", s2 = "Happy", s3, s4;
    private Soap castile;
    private int i;
    private float toy;

    public Bath() {
        System.out.println("Inside Batch()");
        s3 = "Joy";
        toy = 3.14f;
        castile = new Soap();
    }

    // 实例初始化
    {
        i = 47;
    }

    @Override
    public String toString() {
        // 延迟初始化
        if (s4 == null) {
            s4 = "Joy";
        }
        return
                "s1 = " + s1 + "\n" +
                "s2 = " + s2 + "\n" +
                "s3 = " + s3 + "\n" +
                "s4 = " + s4 + "\n" +
                "i = " + i + "\n" +
                "toy = " + toy + "\n" +
                "castile = " + castile;
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}
