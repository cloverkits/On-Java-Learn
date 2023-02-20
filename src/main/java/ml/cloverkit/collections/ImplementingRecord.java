package ml.cloverkit.collections;

interface Star {
    double brightness();
    double density();
}

record RedDwarf(double brightness) implements Star {

    @Override
    public double density() {
        return 100.0;
    }
}