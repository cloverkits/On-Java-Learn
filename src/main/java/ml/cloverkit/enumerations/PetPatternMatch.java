package ml.cloverkit.enumerations;

import java.util.List;

public class PetPatternMatch {
    static void careFor(Pet p) {
        switch (p) {
            case Dog d -> d.walk();
            case Fish f -> f.changeWater();
            case Pet sp -> sp.feed();
        }
    }

    static void petCare() {
        List.of(new Dog(), new Fish())
                .forEach(PetPatternMatch::careFor);
    }
}
