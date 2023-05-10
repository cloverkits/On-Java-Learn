package ml.cloverkit.validating;

class Loaded {
    public void go() {
        assert false: "Loaded.go()";
    }
}

public class LoaderAssertions {
    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        new Loaded().go();
    }
}
