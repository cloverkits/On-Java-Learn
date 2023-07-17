package ml.cloverkit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;   // 未经检查的类型转换

        // ls[1] = new ArrayList<Integer>();
        // 问题：List<String> 是 Object 类型的子类
        Object[] objects = ls;      // 也可以这样分配
        // 顺利的编译及运行：
        objects[1] = new ArrayList<>();

        // 不过如果你的需求很直接，可以创建一个范型的数组 (虽然会发出 unchecked cast 警告):
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
        Arrays.setAll(spheres, n -> new ArrayList<>());
    }
}
