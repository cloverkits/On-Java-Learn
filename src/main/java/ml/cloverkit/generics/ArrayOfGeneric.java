package ml.cloverkit.generics;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            gia = (Generic<Integer>[]) new Object[SIZE];
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // 运行时的类型是原始类型 (已被擦除):
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
        // 编译是错误
        // gia[1] = new Object();
        // 在编译时发现类型不匹配
        // gia[2] = new Generic<Double>();
    }
}
