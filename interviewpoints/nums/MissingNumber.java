package com.skcoder.interviewpoints.nums;

import java.util.stream.IntStream;

public class MissingNumber {
    void main() {
        int[] arr = {1, 2, 4, 5, 6}; // Missing number is 3
        int n = 6; // Expected range is 1 to 6

        int totalSum = IntStream.rangeClosed(1, n).sum(); //21
        int arraySum = IntStream.of(arr).sum(); //18
        int missingNumber = totalSum - arraySum; //21 - 18 = 3
        System.out.println("Missing Number: " + missingNumber);

    }
}
