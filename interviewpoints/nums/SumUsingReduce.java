package com.skcoder.interviewpoints.nums;

import java.util.Arrays;
import java.util.List;

public class SumUsingReduce {
    void main() {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        int sum01 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum01);

        int sum02 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum02);
    }
}
