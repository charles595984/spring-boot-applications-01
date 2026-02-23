package com.skcoder.interviewpoints.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/*
ignore null and empty values,
trim space for each string,
filter strings startwith 'A' (case sensitive),
remove duplicates, and
finally sort the values
*/

public class StringStreams {
    void main() {
        List<String> words = Arrays.asList("Apple", "Banana", "kiwi ", "Orange", "banana", null, "", "Grapes", "Aapple");
        List<String> result = words.stream()
                .filter(Objects::nonNull)                  // ignore null
                .map(String::trim)                         // trim spaces
                .filter(s -> !s.isEmpty())           // ignore empty
                .filter(s -> s.startsWith("A"))      // starts with 'A' (case-sensitive)
                .distinct()                                // remove duplicates
                .sorted()                                  // sort ascending
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
