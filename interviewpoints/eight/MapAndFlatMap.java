package com.skcoder.interviewpoints.eight;

import java.util.Arrays;
import java.util.List;

public class MapAndFlatMap {
    void main() {
        List<Integer> list01 = List.of(1, 2, 3);
        List<Integer> result01 = list01.stream().map(i -> i * i).toList();
        IO.println("Result:: " + result01);

        List<List<Integer>> list02 = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> result02 = list02.stream().flatMap(List::stream).toList();
        IO.println("Result:: " + result02);

        List<String> list03 = Arrays.asList("apple", "banana", "cherry");
        List<String> result03 = list03.stream().map(String::toUpperCase).toList();
        IO.println("Result::" + result03);

        List<List<String>> list04 = Arrays.asList(Arrays.asList("apple", "banana"), Arrays.asList("mango", "cherry"));
        List<String> result04 = list04.stream().flatMap(List::stream).toList();
        IO.println("Result::" + result04);
    }
}
