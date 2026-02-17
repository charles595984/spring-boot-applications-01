package com.skcoder.interviewpoints.nums;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumbers {
    void main() {
        int[] arr = {1, 2, 2, 4, 6}; // Missing numbers are 3 and 5
        int n = 6; // Expected range is 1 to 6

        // Put all array elements into a Set
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        System.out.println(set); //[1, 2, 4, 6]
        // Find numbers from 1 to n that are not in the set
        List<Integer> missing = IntStream
                .rangeClosed(1, n)
                .filter(num -> !set.contains(num))
                .boxed()
                .toList();
        System.out.println("Missing Numbers: " + missing);
    }
}
