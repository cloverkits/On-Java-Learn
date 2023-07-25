package ml.cloverkit.enums;

import java.util.EnumSet;

import static ml.cloverkit.enums.AlarmPoints.*;

// EnumSets 的操作
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);    // 为空
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(START1, START2, KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(START1, START2, KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
