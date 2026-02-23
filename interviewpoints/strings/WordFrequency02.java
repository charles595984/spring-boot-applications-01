package com.skcoder.interviewpoints.strings;

import java.util.Arrays;

public class WordFrequency02 {
    void main() {
        String[] arr = {"java,spring", "java,hibernate,java", "sql", "java", "spring,java"};
        long count = Arrays.stream(arr)
                .flatMap(s -> Arrays.stream(s.split(",")))
                .filter(word -> word.equals("java"))
                .count();
        System.out.print("Word Count: " + count);
    }
}
