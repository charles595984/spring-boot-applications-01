package com.skcoder.interviewpoints.nums;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberFrequency {

    void main() {
        Integer[] arr01 = {1, 2, 3, 4, 5, 4, 5, 5};
        Map<Integer, Long> freqWrapper = Arrays
                .stream(arr01)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println("Element Frequency for given Wrapper Array: " + freqWrapper);

        int[] arr02 = {1, 2, 3, 4, 5, 4, 5, 5};
        Map<Integer, Long> elementFreqGivenWrapper = Arrays
                .stream(arr02)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println("Element Frequency for given Primitive Array: " + elementFreqGivenWrapper);

        List<Integer> arr03 = Arrays.asList(1, 2, 3, 4, 5, 4, 5, 5);
        Map<Integer, Long> elementFreqGivenList = arr03
                .stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println("Element Frequency for given List: " + elementFreqGivenList);

        List<Integer> nonRepeatedNumberList = elementFreqGivenList
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("non-Repeated Number List: " + nonRepeatedNumberList);

        List<Integer> repeatedNumberList = elementFreqGivenList
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Repeated Number List: " + repeatedNumberList);
    }
}
