package ml.cloverkit.innerclasses;

/**
 * 匿名内部类调用基类构造器
 */
public class Parcel8 {

    public Wrapping wrapping(int x) {
        // 积累构造器调用
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }
}
