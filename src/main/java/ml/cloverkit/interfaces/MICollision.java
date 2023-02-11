package ml.cloverkit.interfaces;

interface Bob1 {
    default void bob() {
        System.out.println("Bob1:bob");
    }
}

interface Bob2 {
    default void bob() {
        System.out.println("Bob2:bob");
    }
}

class Bob implements Bob1, Bob2 {
    @Override
    public void bob() {
        Bob1.super.bob();
    }
}

interface Sam1 {
    default void sam() {
        System.out.println("Sam1:sam");
    }
}

interface Sam2 {
    default void sam(int i) {
        System.out.println(i * 2);
    }
}

// 因为参数列表不同可以正常工作
class Sam implements Sam1, Sam2 {}

interface Max1 {
    default void max() {
        System.out.println("Max1::max");
    }
}

interface Max2 {
    default int max() {
        return 47;
    }
}

//class Max implements Max1, Max2 {
//
//    @Override
//    public void max() {
//        Max1.super.max();
//    }
//}

public class MICollision {
    public static void main(String[] args) {

    }
}
