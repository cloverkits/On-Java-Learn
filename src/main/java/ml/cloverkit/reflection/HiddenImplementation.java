package ml.cloverkit.reflection;

import ml.cloverkit.reflection.interfacea.A;
import ml.cloverkit.reflection.interfacea.HiddenC;

import java.lang.reflect.Method;

// 偷偷绕过包隐藏 🫥
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // 编译错误：无法找到符号 'C':
        /* if (a instanceof C) {
            C c = (C) a;
            c.g()
        } */
        // 呀！反射依然允许我们调用个 g():
        callHiddenMethod(a, "g");
        // 甚至访问权限最小的方法:
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
