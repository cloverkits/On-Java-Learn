package ml.cloverkit.strings;

public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        // 旧的方式
        System.out.println("Row 1: [" + x + " " + y + "]");
        // 新的方式
        System.out.format("Row 1: [%d %f]%n", x, y);
        // 或者 🤔
        System.out.printf("Row 1: [%d %f]%n", x, y);
    }
}
