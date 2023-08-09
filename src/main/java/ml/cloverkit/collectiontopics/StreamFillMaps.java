package ml.cloverkit.collectiontopics;

import ml.cloverkit.Pair;
import ml.cloverkit.Rand;
import onjava.Count;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Letters implements Supplier<Pair<Integer, String>> {
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> get() {
        return new Pair<>(number++, "" + letter++);
    }
}

public class StreamFillMaps {
    public static void main(String[] args) {
        Map<Integer, String> m = Stream.generate(new Letters())
                .limit(11)
                .collect(Collectors.toMap(Pair::key, Pair::value));
        System.out.println(m);

        // 分别提供键和值:
        Rand.String rs = new Rand.String(3);
        Count.Character cc = new Count.Character();
        Map<Character, String> mcs = Stream.generate(() -> Pair.make(cc.get(), rs.get()))
                .limit(8)
                .collect(Collectors.toMap(Pair::key, Pair::value));
        System.out.println(mcs);

        // 用一个类来生成键，它们使用同一个值:
        Map<Character, String> mcs2 = Stream.generate(() -> Pair.make(cc.get(), "Val"))
                .limit(8)
                .collect(Collectors.toMap(Pair::key, Pair::value));
        System.out.println(mcs2);
    }
}
