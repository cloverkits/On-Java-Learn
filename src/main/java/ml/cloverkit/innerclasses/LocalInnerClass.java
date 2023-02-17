package ml.cloverkit.innerclasses;

@FunctionalInterface
interface Counter {
    int next();
}
public class LocalInnerClass {

    private int count = 0;

    Counter getCounter(final String name) {
        // 一个局部内部类
        class LocalCounter implements Counter {
            LocalCounter() {
                // 局部内部类可以有一个构造器
                System.out.println("LocalCounter");
            }

            @Override
            public int next() {
                // 访问局部内部类的 final 变量
                System.out.println(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    // 使用匿名内部类实现同样的功能
    Counter getCounter2(final String name) {
        return new Counter() {
            // 匿名内部类不能有具名构造器
            // 只有一个实例初始化部分
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }

    Counter getCounterLambda(final String name) {
        {
            System.out.println("Counter Lambda");
        }
        return () -> {
            System.out.println(name);
            return count++;
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Local inner"),
                c2 = lic.getCounter2("Anonymous inner"),
                c3 = lic.getCounterLambda("Lambda inner");

        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(c3.next());
        }
    }
}
