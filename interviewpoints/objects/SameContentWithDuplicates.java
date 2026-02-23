package com.skcoder.interviewpoints.objects;

import java.util.HashMap;
import java.util.Map;

public class SameContentWithDuplicates {
    void main() {
        Object[] arr01 = {1, 2, 3, 2, 1, "$", "a", "$", "*", 8};
        Object[] arr02 = {"a", 1, "$", 2, 3, "*", 1, 2, "$", 8};
        boolean isSameContent = haveSameContentIgnoringOrder(arr01, arr02);
        System.out.println("Same content ignoring order but respecting duplicates: " + isSameContent);
    }

    public static boolean haveSameContentIgnoringOrder(Object[] arr1, Object[] arr2) {
        if (arr1.length != arr2.length) return false;
        Map<Object, Integer> freqMap1 = buildFrequencyMap(arr1);
        Map<Object, Integer> freqMap2 = buildFrequencyMap(arr2);
        return freqMap1.equals(freqMap2);
    }

    private static Map<Object, Integer> buildFrequencyMap(Object[] arr) {
        Map<Object, Integer> freqMap = new HashMap<>();
        for (Object obj : arr) {
            freqMap.put(obj, freqMap.getOrDefault(obj, 0) + 1);
        }
        return freqMap;
    }

}
