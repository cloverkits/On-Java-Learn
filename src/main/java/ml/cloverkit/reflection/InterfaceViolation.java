package ml.cloverkit.reflection;

import ml.cloverkit.reflection.interfacea.A;

// 偷偷绕过接口
class B implements A {

    @Override
    public void f() {

    }

    public void g() {}
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // 编译失败
        // a.g();
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}
