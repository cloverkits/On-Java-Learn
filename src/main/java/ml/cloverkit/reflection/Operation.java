package ml.cloverkit.reflection;

import java.util.function.Supplier;

public class Operation {
    public final Supplier<String> description;
    public final Runnable comand;
    public Operation(Supplier<String> descr, Runnable cmd) {
        description = descr;
        comand = cmd;
    }
}
