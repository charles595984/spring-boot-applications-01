package com.skcoder.interviewpoints.objects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SameContentWithoutDuplicates {
    void main() {
        Object[] arr01 = {1, 2, 3, 2, 1, "$", "a", "$", "*", 8};
        Object[] arr02 = {1, 2, 3, 8, "a", "$", "*"};
        Set<Object> set1 = new HashSet<>(Arrays.asList(arr01));
        Set<Object> set2 = new HashSet<>(Arrays.asList(arr02));
        boolean isSameContent = set1.equals(set2);
        System.out.println("Same content without duplicates and orders: " + isSameContent);
    }
}
