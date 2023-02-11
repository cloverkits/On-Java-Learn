package ml.cloverkit.interfaces.interfaceprocessor;

public interface Processor {
    default String name() {
        return getClass().getName();
    }

    Object process(Object input);
}
