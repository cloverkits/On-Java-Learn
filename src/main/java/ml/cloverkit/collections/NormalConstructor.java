package ml.cloverkit.collections;

record Value(int x) {
    // 带有参数列表
    Value(int x) {
        // 必须显式初始化
        this.x = x;
    }
}
