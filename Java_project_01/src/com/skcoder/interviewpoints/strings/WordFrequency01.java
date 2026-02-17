package com.skcoder.interviewpoints.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency01 {
    void main() {
        String text = "hi how hi are you are you you";
        Map<String, Long> wordFrequency = Arrays.stream(text.toLowerCase().split(" "))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("Word Frequency: " + wordFrequency);
    }
}
