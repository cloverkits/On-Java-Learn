package ml.cloverkit.reflection.toys;

public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftc = FancyToy.class;
        // 生成确切的类型
        FancyToy fancyToy = ftc.getConstructor().newInstance();
        Class<? super FancyToy> up = ftc.getSuperclass();
        // 下面的代码无法通过编译
        // Class<Toy> up2 = ftc.getSuperclass();
        // 只能生成 Object
        Object obj = up.getConstructor().newInstance();
    }
}
