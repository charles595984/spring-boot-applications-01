package com.skcoder.interviewpoints.list;

import java.util.List;
import java.util.stream.Stream;

public class UnionElementsFromTwoList {
    void main() {
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(3, 4, 5, 6);
        List<Integer> unionElements = Stream
                .concat(list1.stream(), list2.stream())
                .distinct()
                .toList();
        IO.println("Union Elements from two list: " + unionElements);
    }
}
