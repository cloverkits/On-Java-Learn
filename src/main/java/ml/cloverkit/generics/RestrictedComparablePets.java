package ml.cloverkit.generics;

class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

// 或直接这样:
class Gecko extends ComparablePet {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}