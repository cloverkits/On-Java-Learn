package ml.cloverkit.interfaces;

@FunctionalInterface
public interface Operation {

    void execute();

    static void runOpt(Operation ...ops) {
        for (Operation op : ops) {
            op.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }
}
