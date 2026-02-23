package com.skcoder.interviewpoints.oops;

// Parent class
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child classes
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class PloymorphismMain {
    void main() {
        Animal myDog = new Dog();  // Polymorphism
        Animal myCat = new Cat();  // Polymorphism

        myDog.sound();  // Output: Dog barks
        myCat.sound();  // Output: Cat meows
    }
}
