package ml.cloverkit.collections;

record FinalFields(int i) {

    int timesTen() {
        return i * 10;
    }

    // 不能给最终变量 i 赋值
//    void tryToChange() {
//        i++;
//    }
}
