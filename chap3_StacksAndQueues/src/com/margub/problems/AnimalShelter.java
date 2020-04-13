package com.margub.problems;

import com.margub.extra.Animal;
import com.margub.extra.Cat;
import com.margub.extra.Dog;

import java.util.LinkedList;

public class AnimalShelter {

    private LinkedList<Cat> cats = new LinkedList<>();
    private LinkedList<Dog> dogs = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        } else {
            dogs.addLast((Dog) animal);
        }
    }

    private Dog dequeueDog() {
        if (dogs.isEmpty()) {
            throw new IllegalStateException("No Dog in shelter");
        }
        return dogs.removeFirst();
    }

    private Cat dequeueCat() {
        if (cats.isEmpty()) {
            throw new IllegalStateException("No Cat in shelter");
        }
        return cats.removeFirst();
    }

    public Animal dequeAny() {
        if (cats.isEmpty()) {
            return dequeueDog();
        }
        if (dogs.isEmpty()) {
            return dequeueCat();
        }
        Cat first = cats.getFirst();
        Dog second = dogs.getFirst();

        if (first.getOrder() > second.getOrder()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());

        System.out.println(animalShelter.dequeAny() instanceof Cat);
        System.out.println(animalShelter.dequeueDog());
        System.out.println(animalShelter.dequeAny() instanceof Dog);
    }


}
