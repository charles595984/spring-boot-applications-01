package com.skcoder.interviewpoints.sortings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EventNumberWithDescending {
    void main() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> eventDescending = list.stream()
                .filter(i -> i % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Event Number with descending order" + eventDescending);
    }
}
