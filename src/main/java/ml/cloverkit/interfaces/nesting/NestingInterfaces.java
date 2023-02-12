package ml.cloverkit.interfaces.nesting;

class A {
    interface B {
        void f();
    }
    public class BImp implements B {
        @Override
        public void f() {

        }
    }
    public class BImp2 implements B {
        @Override
        public void f() {

        }
    }
    public interface C {
        void f();
    }

    class CImp implements C {
        @Override
        public void f() {

        }
    }
    private class CImp2 implements C {
        @Override
        public void f() {

        }
    }
    private interface D {
        void f();
    }
    private class DImp implements D {
        @Override
        public void f() {

        }
    }
    public class DImp2 implements D {
        @Override
        public void f() {

        }
    }
    public D getD() {
        return new DImp2();
    }
    private D dRef;
    public void receive(D d) {
        dRef = d;
        dRef.f();
    }
}
interface E {
    interface G {
        void f();
    }
    // 多余的 public
    public interface H {
        void f();
    }

    void g();
    // 接口内不能使用 private
    // private interface T {}
}
public class NestingInterfaces {
    public class BImp implements A.B {
        @Override
        public void f() {

        }
    }
    class CImp implements A.C {
        @Override
        public void f() {

        }
    }
    // private 接口只能在定义的类里实现
    // class DImp implements A.D {
    //    public void f() {}
    // }
    class EImp implements E {
        @Override
        public void g() {

        }
    }
    class EGImp implements E.G {

        @Override
        public void f() {

        }
    }
    class EImp2 implements E {

        @Override
        public void g() {

        }
        class EG implements E.G {
            @Override
            public void f() {

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        // 无法访问 A.D
        // A.D d = a.getD();
        // 只能放回 A.D
        // A.DImp2 di2 = a.getD();
        // 无法访问该接口方法
        // a.getD().f()
        a.receive(a.getD());
        A a2 = new A();
        a2.receive(a.getD());
    }
}
