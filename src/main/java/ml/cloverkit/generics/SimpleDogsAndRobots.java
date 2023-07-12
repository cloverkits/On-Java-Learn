package ml.cloverkit.generics;

class Communicatesimply {
    static void perform(Performs performs)  {
        performs.speak();
        performs.sit();
    }
}

public class SimpleDogsAndRobots {
    public static void main(String[] args) {
        Communicatesimply.perform(new PerformingDog());
        Communicatesimply.perform(new Robot());
    }
}
