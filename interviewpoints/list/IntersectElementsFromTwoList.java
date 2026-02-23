package com.skcoder.interviewpoints.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.IO.println;

/*
Using Java8: Time Complexity O(n^2)
Using Set: Time Complexity O(n)
*/

public class IntersectElementsFromTwoList {
    void main() {
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(3, 4, 5, 6);

        List<Integer> intersect1 = new ArrayList<>(list1);
        intersect1.retainAll(list2);
        println("IntersectElementsFromTwoList.main" + intersect1);

        System.out.println("If both list size are small using Functional Style");
        List<Integer> intersect2 = list1.stream()
                .filter(list2::contains)
                .toList();
        println("IntersectElementsFromTwoList: " + intersect2);

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        println("IntersectElementsFromTwoList: " + set1);

    }
}
