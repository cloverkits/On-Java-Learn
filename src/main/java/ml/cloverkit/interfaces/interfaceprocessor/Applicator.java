package ml.cloverkit.interfaces.interfaceprocessor;

public class Applicator {
    // 策略模式方法
    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
