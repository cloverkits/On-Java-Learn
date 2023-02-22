package ml.cloverkit.functional;

class This {
    void two(int i, double d) {
        System.out.println("i = " + i + ", d = " + d);
    }

    void three(int i, double d, String s) {
        System.out.println("i = " + i + ", d = " + d + ", s = " + s);
    }

    void four(int i, double d, String s, char c) {
        System.out.println("i = " + i + ", d = " + d + ", s = " + s + ", c = " + c);
    }
}

interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}


public class MultiUnbound {
    public static void main(String[] args) {
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;
        This aThis = new This();
        twoArgs.call2(aThis, 11, 3.14);
        threeArgs.call3(aThis, 11, 3.14, "Three");
        fourArgs.call4(aThis, 11, 3.14, "Three", 'Z');
    }
}
