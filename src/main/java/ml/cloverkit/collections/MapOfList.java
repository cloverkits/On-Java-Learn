package ml.cloverkit.collections;

import reflection.pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOfList {

    public static final Map<Person, List<? extends Pet>> petPeople = new HashMap<>();

    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(
                new Cymric("Molly"),
                new Mutt("Spot")
        ));
        petPeople.put(new Person("Kate"), List.of(
                new Cat("Margrett")
        ));
        petPeople.put(new Person("Marilyn"), List.of(
                new Pug("Louie aka Louis Snorkelstein Dupree"),
                new Cat("Stanford"),
                new Cat("Pinkola")
        ));
    }

    public static void main(String[] args) {
        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            System.out.println(person + " has:");
            for (Pet pet : petPeople.get(person)) {
                System.out.println("   " + pet);
            }
        }
    }
}
