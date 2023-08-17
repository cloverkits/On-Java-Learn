// WeekHashMap 的演示
package ml.cloverkit.collectiontopics;

import java.util.*;

public class CanonicalMapping {
    static void showKeys(Map<String, String> m) {
        // 显示排序后的键
        List<String> keys = new ArrayList<>(m.keySet());
        Collections.sort(keys);
        System.out.println(keys);
    }

    public static void main(String[] args) {
        int size = 100;
        String[] savedKeys = new String[size];
        WeakHashMap<String, String> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            String key = String.format("%03d", i);
            String value = Integer.toString(i);
            if (i % 3 == 0)
                savedKeys[i] = key; // 当作 “真正” 的引用来保存
            map.put(key, value);
        }
        showKeys(map);
        System.gc();
        showKeys(map);
    }
}
