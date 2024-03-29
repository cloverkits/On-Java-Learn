package ml.cloverkit.arrays;

import java.util.Arrays;

public class MultiDimWrapperArray {
    public static void main(String[] args) {
        Integer[][] a1 = {  // 自动装箱 📦
                { 1, 2, 3 },
                { 4, 5, 6 },
        };
        Double[][][] a2 = { // 自动装箱 📦
                {{1.1, 2.2}, {3.3, 4.4}},
                {{5.5, 6.6}, {7.7, 8.8}},
                {{9.9, 1.2}, {2.3, 3.4}},
        };
        String[][] a3 = {
                {"The", "Quick", "Sly", "Fox"},
                {"jumped", "Over"},
                {"The", "Lazy", "Brown", "Dog", "&", "friend"},
        };
        System.out.println("a1: " + Arrays.deepToString(a1));
        System.out.println("a2: " + Arrays.deepToString(a2));
        System.out.println("a3: " + Arrays.deepToString(a3));
    }
}
