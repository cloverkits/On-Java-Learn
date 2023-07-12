package ml.cloverkit.generics;

import reflection.pets.Dog;

// Java 中并无 (直接的) 潜在类型机制
class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }

    @Override
    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {}
}

class Robot implements Performs {
    @Override
    public void speak() {
        System.out.println("Click!");
    }

    @Override
    public void sit() {
        System.out.println("Clank!");
    }

    public void oilChange() {}
}

class Comunicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        Comunicate.perform(new PerformingDog());
        Comunicate.perform(new Robot());
    }
}
