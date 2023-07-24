package ml.cloverkit.enums;

public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> integerClass = Integer.class;
        try {
            for (Integer en : integerClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}
