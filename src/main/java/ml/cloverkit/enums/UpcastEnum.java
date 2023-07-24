package ml.cloverkit.enums;
// 如果向上转型，便会丢失 values() 方法

enum Search { HITHER, YON }

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; // 向上转型
        // e.values();   // Enum 中没有 values 方法
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
