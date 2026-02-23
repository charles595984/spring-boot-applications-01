package com.skcoder.interviewpoints.fis;

@FunctionalInterface
public interface UserdefinedFunctionalInterface {
    void execute();  // Single abstract method

    // You can add default or static methods
    default void log1(String message) {
        System.out.println("Log1: " + message);
    }

    default void log2(String message) {
        System.out.println("Log2: " + message);
    }

    static void printInfo1() {
        System.out.println("Print Statement1");
    }

    static void printInfo2() {
        System.out.println("Print Statement2");
    }
}
