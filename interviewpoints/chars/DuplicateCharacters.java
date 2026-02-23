package com.skcoder.interviewpoints.chars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharacters {
    void main() {
        String str = "programming";
        Map<Character, Long> freq = str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        IO.println("Character Frequency: " + freq);

        //Find Duplicate Characters
        List<Map.Entry<Character, Long>> duplicateChars = freq
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .toList();
        IO.println("Duplicate Characters: " + duplicateChars);

        //Remove Duplicates from String
        String removeDuplicates = str.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .distinct()
                .collect(Collectors.joining());
        IO.println("Remove Duplicates Characters: " + removeDuplicates);

    }
}
