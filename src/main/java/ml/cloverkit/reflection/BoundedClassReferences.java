package ml.cloverkit.reflection;

public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        // 或者任何继承了 Number 的类
    }
}
