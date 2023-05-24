package ml.cloverkit.reflection;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        intClass = double.class;
        Class<Integer> genericIntClass = int.class;
        // 一样
        genericIntClass = Integer.class;
        // 不合法
        // genericIntClass = double.class;
    }
}
