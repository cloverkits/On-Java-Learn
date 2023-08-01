package ml.cloverkit.sealedpet;

import java.util.List;

sealed interface Pet {
    void feed();
}

final class Dog implements Pet {
    @Override
    public void feed() {}
    void walk() {}
}

final class Fish implements Pet {
    @Override
    public void feed() {}
    void changeWater() {}
}

public class PetPatternMatch2 {
    static void careFor(Pet p) {
        switch (p) {
            case Dog d -> d.walk();
            case Fish f -> f.changeWater();
        };
    }

    static void petCare() {
        List.of(new Dog(), new Fish())
                .forEach(PetPatternMatch2::careFor);
    }
}
