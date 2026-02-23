package com.skcoder.interviewpoints.fis;


public class UserdefinedFunInterExample {
    void main() {
        UserdefinedFunctionalInterface myFunc = () -> System.out.println("Executing task...");
        myFunc.execute();  // Calls the abstract method

        // Using default method
        myFunc.log1("Task completed1");
        myFunc.log2("Task completed2");

        // Using static method
        UserdefinedFunctionalInterface.printInfo1();
        UserdefinedFunctionalInterface.printInfo2();

    }
}
