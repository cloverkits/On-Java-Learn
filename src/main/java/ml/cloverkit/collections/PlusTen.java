package ml.cloverkit.collections;

record PlusTen(int x) {
    PlusTen {
        x += 10;
    }

    // 对字段的调整只能在构造器中进行
    // void mutate() {
    //     x += 10;
    // }
    public static void main(String[] args) {
        System.out.println(new PlusTen(10));
    }
}
