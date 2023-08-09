package ml.cloverkit;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FillMap {
    private FillMap() {
        // 不允许创建实例
    }

    public static <K, V> Map<K, V> basic(Supplier<Pair<K, V>> pairGen, int size) {
        return Stream.generate(pairGen)
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value));
    }

    public static <K, V> Map<K, V> basic(Supplier<K> keyGen, Supplier<V> valueGen, int size) {
        return Stream.generate(() -> Pair.make(keyGen.get(), valueGen.get()))
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value));
    }

    /**
     * 通用 Map 创建 & 填充工具
     *
     * @param keyGen      key 生成函数
     * @param valueGen    value 生成函数
     * @param mapSupplier Map 生成生成函数
     * @param size        Map 大小
     * @param <K>         Key 类型
     * @param <V>         Value 类型
     * @param <M>         Map 类型
     * @return Map
     */
    public static <K, V, M extends Map<K, V>> M create(Supplier<K> keyGen,
                                                       Supplier<V> valueGen,
                                                       Supplier<M> mapSupplier, int size) {
        return Stream.generate(() -> Pair.make(keyGen.get(), valueGen.get()))
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value, (k, v) -> k, mapSupplier));
    }
}
