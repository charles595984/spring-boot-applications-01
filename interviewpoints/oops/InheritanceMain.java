package com.skcoder.interviewpoints.oops;

import static java.lang.IO.println;

// Parent class
class Vehicle {
    public void start() {
        println("Vehicle is starting...");
    }
    public void stop() {
       println("Vehicle is stopping...");
    }
}

// Child class
class Car extends Vehicle {
    public void honk() {
        println("Car is honking!");
    }
}

public class InheritanceMain {
    void main() {
        Car myCar = new Car();
        myCar.start();  // Inherited from Vehicle
        myCar.honk();   // Specific to Car
        myCar.stop();   // Inherited from Vehicle
    }
}
