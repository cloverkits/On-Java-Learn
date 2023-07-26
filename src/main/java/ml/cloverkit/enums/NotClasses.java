package ml.cloverkit.enums;

enum LikeClasses {
    WINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior1");
        }
    },
    BLINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior2");
        }
    },
    NOD {
        @Override
        void behavior() {
            System.out.println("Behavior3");
        }
    };

    abstract void behavior();
}

public class NotClasses {
    // 编译器不允许将枚举实例作为类类型使用
    // void f1(LikeClasses.WINKEN instance) {} // 不允许
}
