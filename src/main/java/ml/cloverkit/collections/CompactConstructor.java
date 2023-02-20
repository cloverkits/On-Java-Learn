package ml.cloverkit.collections;

record Point(int x, int y) {
    void assertPositive(int val) {
        if (val < 0)
            throw new IllegalArgumentException("negative");
    }

    // 紧凑没有参数列表
    Point {
        assertPositive(x);
        assertPositive(y);
    }
}