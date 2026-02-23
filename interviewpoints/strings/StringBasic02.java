package com.skcoder.interviewpoints.strings;

import static java.lang.IO.println;

public class StringBasic02 {
    void main() {

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        println("String Class Comparison:");
        println(s1.equals(s2)); // true (same content)
        println(s1 == s2);      // true (same objects)

        println("String Object Comparison:");
        println(s1.equals(s3)); // true (same content)
        println(s1 == s3);      // false (different objects)

        IO.println("custom class (equals() not overridden");
        class Person {
            String name;

            Person(String name) {
                this.name = name;
            }
        }
        Person p1 = new Person("Alice");
        Person p2 = new Person("Alice");
        println("\nCustom class comparison:");
        println("p1 == p2       : " + (p1 == p2));          // false (different objects)
        println("p1.equals(p2)  : " + p1.equals(p2));       // false (default equals() behaves like ==)

    }
}
