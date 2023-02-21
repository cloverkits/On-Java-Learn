package ml.cloverkit.collections;

import reflection.pets.Pet;
import reflection.pets.PetCreator;

import java.util.Iterator;

class PetSequence {
    protected Pet[] pets = new PetCreator().array(8);
}
public class NonCollectionSequence extends PetSequence {

    public Iterator<Pet> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() {
                Iterator.super.remove();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}
