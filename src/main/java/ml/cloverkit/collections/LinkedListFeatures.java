package ml.cloverkit.collections;

import reflection.pets.Hamster;
import reflection.pets.Pet;
import reflection.pets.PetCreator;
import reflection.pets.Rat;

import java.util.LinkedList;

public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(new PetCreator().list(5));
        System.out.println(pets);
        // 完全相同
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " + pets.element());
        // 仅当列表为空时存在区别
        System.out.println("pets.peek(): " + pets.peek());

        // 完全相同； 移除并返回第一元素
        System.out.println("pets.remove(): " + pets.remove());
        System.out.println("pets.removeFirst(): " + pets.removeFirst());
        // 仅当列表为空时存在区别：
        System.out.println("pets.poll(): " + pets.poll());
        System.out.println(pets);

        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);
        pets.offer(new PetCreator().get());
        System.out.println("After offer(): " + pets);
        pets.add(new PetCreator().get());
        System.out.println("After add(): " + pets);
        pets.addLast(new Hamster());
        System.out.println("After addLast(): " + pets);
        System.out.println("pets.removeLast(): " + pets.removeLast());
    }
}
