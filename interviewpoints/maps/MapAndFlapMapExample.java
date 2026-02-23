package com.skcoder.interviewpoints.maps;

import java.util.List;

public class MapAndFlapMapExample {
    void main() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> mapResult = list
                .stream()
                .map(i -> i * i)
                .toList();
        IO.println("Map Result: " + mapResult);

        List<List<Integer>> nestedList = List.of(
                List.of(1, 2, 3),
                List.of(4, 5)
        );
        List<Integer> flatMapResult = nestedList
                .stream()
                .flatMap(List::stream)
                .toList();
        IO.println("Flat Map Result: " + flatMapResult);

    }
}
