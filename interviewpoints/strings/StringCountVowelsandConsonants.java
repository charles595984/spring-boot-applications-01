package com.skcoder.interviewpoints.strings;

public class StringCountVowelsandConsonants {
    void main() {
        String str = "interview";
        long vowels = str.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
        long consonants = str.length() - vowels;
        System.out.println("Vowels Count: " + vowels);
        System.out.println("Consonants Count: " + consonants);
    }
}
