package ml.cloverkit.enums;


// 重写常量特定方法
public enum OverrideConstantSpecific {
    NUT, BOLT, WASHER {
        @Override
        void f() {
            System.out.println("Overridden method");
        }
    }
    ;

    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            System.out.print(ocs + ": ");
            ocs.f();
        }
    }
}
