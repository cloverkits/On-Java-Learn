package ml.cloverkit.reflection;

import java.util.Random;

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.random.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 47;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random random = new Random(47);
    public static void main(String[] args) throws Exception {
        Class<Initable> initable = Initable.class;
        System.out.println("After creating Initable ref");
        // 不会触发初始化
        System.out.println(Initable.STATIC_FINAL);
        // 触发初始化
        System.out.println(Initable.STATIC_FINAL2);
        // 触发初始化
        System.out.println(Initable2.staticNonFinal);
        Class<?> initable3 = Class.forName("ml.cloverkit.reflection.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
