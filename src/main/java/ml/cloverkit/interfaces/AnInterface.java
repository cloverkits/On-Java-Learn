package ml.cloverkit.interfaces;

public interface AnInterface {
    void firstMethod();
    void secondMethod();
    default void newMethod() {
        System.out.println("new Method");
    }
}
