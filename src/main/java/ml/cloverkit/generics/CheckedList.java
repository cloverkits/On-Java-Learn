package ml.cloverkit.generics;

import reflection.pets.Cat;
import reflection.pets.Dog;
import reflection.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
    @SuppressWarnings({"unchecked", "rawtypes"})
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1);  // 可以安静的传入 Cat

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2);  // 会抛出异常
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }

        // 派生类型可以正常工作:
        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(), Pet.class
        );
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
