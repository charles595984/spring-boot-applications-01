package com.skcoder.interviewpoints.chars;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedCharacter {
    void main() {
        String str = "programming";
        Map<Character, Long> freq = str
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println("Character Frequency: " + freq);

        List<Character> repeatedChars = freq
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Repeated Characters: " + repeatedChars);

        Character secondRepeatedChars = freq
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .skip(0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("Second Repeated Characters: " + secondRepeatedChars);

    }
}
