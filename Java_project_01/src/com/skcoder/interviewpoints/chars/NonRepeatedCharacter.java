package com.skcoder.interviewpoints.chars;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatedCharacter {
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

        List<Character> nonRepeatedChars = freq
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("non-Repeated Characters: " + nonRepeatedChars);

        Character secondNonRepeatedChars = freq
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("Second Non-Repeated Characters: " + secondNonRepeatedChars);

    }
}
