package Assignment6;

import java.util.LinkedList;
import java.util.Queue;

// Base class for animals
abstract class Animal {
    private String name;
    private long arrivalTime;

    public Animal(String name, long arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
}

// Dog class
class Dog extends Animal {
    public Dog(String name, long arrivalTime) {
        super(name, arrivalTime);
    }
}

// Cat class
class Cat extends Animal {
    public Cat(String name, long arrivalTime) {
        super(name, arrivalTime);
    }
}

// Shelter class
class AnimalShelter {
    private Queue<Dog> dogs;
    private Queue<Cat> cats;
    private long currentTime;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        currentTime = 0;
    }

    // method for adding animals to the shelter
    public void enqueue(Animal animal) {
        animal = setArrivalTime(animal);
        if (animal instanceof Dog) {
            dogs.offer((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.offer((Cat) animal);
        }
    }

    //   Method to set arival time
    private Animal setArrivalTime(Animal animal) {
        animal = new Animal(animal.getName(), currentTime++) {};
        return animal;
    }

    // Dequeue the oldest animal (any)
    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return null;
        } else if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
            return dogs.poll();
        } else {
            // Compare the arrival times
            return (dogs.peek().getArrivalTime() < cats.peek().getArrivalTime()) ? dogs.poll() : cats.poll();
        }
    }

    // Dequeue the oldest dog
    public Dog dequeueDog() {
        return dogs.poll();
    }

    // Dequeue the oldest cat
    public Cat dequeueCat() {
        return cats.poll();
    }
}

// Example:
public class VetClinic {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Dog("Saxon", 0));
        shelter.enqueue(new Cat("Orangejello", 0));
        shelter.enqueue(new Dog("Toque", 0));
        shelter.enqueue(new Cat("Shelby", 0));

        System.out.println("Adopting any animal: " + shelter.dequeueAny().getName());
        System.out.println("Adopting a dog: " + shelter.dequeueDog().getName());
        System.out.println("Adopting a cat: " + shelter.dequeueCat().getName());
    }
}
