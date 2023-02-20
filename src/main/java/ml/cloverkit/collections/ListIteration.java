package ml.cloverkit.collections;

import reflection.pets.Pet;
import reflection.pets.PetCreator;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(8);
        ListIterator<Pet> it = pets.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next()  + ", " + it.nextIndex() + ", " + it.previousIndex());
        }

        while (it.hasPrevious())
            System.out.println(it.previous().id() + " ");

        System.out.println();
        System.out.println(pets);

        while (it.hasNext()) {
            it.next();
            it.set(new PetCreator().get());
        }
        System.out.println(pets);
    }
}
