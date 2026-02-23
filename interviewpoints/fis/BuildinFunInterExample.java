package com.skcoder.interviewpoints.fis;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class BuildinFunInterExample {
    void main() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        Predicate<String> startsWithA = name -> name.startsWith("A");
        List<String> predicateResult = names.stream().filter(startsWithA).toList();
        IO.println("Predicate Result" + predicateResult);

        Function<String, Integer> nameLength = String::length;
        List<Integer> functionResult = names.stream().map(nameLength).toList();
        IO.println("Function Result" + functionResult);

        Consumer<String> printUpperCase = name -> System.out.println(name.toUpperCase());
        names.forEach(printUpperCase);

        Predicate<String> lengthGreaterThan3 = name -> name.length() > 3;
        Function<String, String> toUpperCase = String::toUpperCase;
        Consumer<String> printName = System.out::println;
        names.stream()
                .filter(lengthGreaterThan3)   // Predicate
                .map(toUpperCase)             // Function
                .forEach(printName);          // Consumer

    }
}
