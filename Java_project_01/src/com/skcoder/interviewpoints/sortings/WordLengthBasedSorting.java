package com.skcoder.interviewpoints.sortings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WordLengthBasedSorting {
    void main() {
        List<String> list = Arrays.asList("java", "python", "html", "kotlin", "c++", "c");
        List<String> sortedList = list.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
        System.out.println("Sorted List: "+ sortedList);
    }
}
