package com.skcoder.interviewpoints.chars;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {
    void main() {
        String str = "programming";
        Map<Character, Long> charFreq = str
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        IO.println("Character Frequency: " + charFreq);
    }
}
