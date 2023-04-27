package ml.cloverkit.exceptions;

public class MultiCatch2 {
    void x() throws Except1, Except2, Except3, Except4 {}
    void process() {}
    void f() {
        try {
            x();
        } catch (Except1 | Except2 e) {
            process();
        } catch (Except3 | Except4 e) {
            process();
        }
    }
}
