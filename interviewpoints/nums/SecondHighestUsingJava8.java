package com.skcoder.interviewpoints.nums;

import java.util.Arrays;
import java.util.Comparator;

/*
- Stream + sorting → concise, but less efficient.
- One-pass loop → fastest and simplest.
*/

public class SecondHighestUsingJava8 {
    void main() {
        int[] numbers = {12, 35, 1, 10, 34, 1};

        Integer secondHighest = Arrays.stream(numbers)      // Convert array to stream
                .boxed()                                    // Convert int to Integer
                .distinct()                                 // Remove duplicates
                .sorted(Comparator.reverseOrder())          // Sort in descending order
                .skip(1)                                 // Skip the first (largest)
                .findFirst()                                // Get the next element
                .orElse(null);                        // Handle case if not found

        if (secondHighest != null) {
            System.out.println("Second highest number: " + secondHighest);
        } else {
            System.out.println("No second highest number exists.");
        }

    }
}
