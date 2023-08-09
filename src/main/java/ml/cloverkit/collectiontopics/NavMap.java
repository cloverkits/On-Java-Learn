// NavigableMap 可以生成 Map 的片段

package ml.cloverkit.collectiontopics;

import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

import static ml.cloverkit.HTMLColors.*;

public class NavMap {
    public static final NavigableMap<Integer, String> COLORS = new ConcurrentSkipListMap<>(MAP);

    public static void main(String[] args) {
        show(COLORS.firstEntry());
        border();
        show(COLORS.lastEntry());
        border();
        NavigableMap<Integer, String> toLime = COLORS.headMap(rgb("Lime"), true);
        show(toLime);
        border();
        show(COLORS.ceilingEntry(rgb("DeepSkyBlue") - 1));
        border();
        show(COLORS.floorEntry(rgb("DeepSkyBlue") - 1));
        border();
        show(toLime.descendingMap());
        border();
        show(COLORS.tailMap(rgb("MistyRose"), true));
        border();
        show(COLORS.subMap(
                rgb("Orchid"), true,
                rgb("DarkSalmon"), false
        ));
    }
}
