package ml.cloverkit.reflection.toys;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    // 可以将下面这个无参构造器注释一下来看一下 NoSuchMethodError
    public Toy() {}
    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " +  cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("ml.cloverkit.reflection.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // 对应类要有 public 的无参构造器
            obj = up.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate");
        }
        printInfo(obj.getClass());
    }
}
