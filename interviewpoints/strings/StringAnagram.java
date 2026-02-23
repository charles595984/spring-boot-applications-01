package com.skcoder.interviewpoints.strings;

import java.util.Arrays;

public class StringAnagram {
    void main() {
        String s1 = "listen", s2 = "silent";
        boolean isAnagram = Arrays.equals(
                s1.chars().sorted().toArray(),
                s2.chars().sorted().toArray()
        );
        System.out.println("Anagram Result: " + isAnagram);
    }
}
