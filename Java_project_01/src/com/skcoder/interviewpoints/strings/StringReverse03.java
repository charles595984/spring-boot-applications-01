package com.skcoder.interviewpoints.strings;

import java.util.stream.IntStream;

/*
 * Time Complexcity: O(n2)
 * */
public class StringReverse03 {
    void main() {
        String str = "hello";
        String reversed = IntStream
                .range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .map(String::valueOf)
                .reduce("", (a, b) -> a + b);
        System.out.println("Reversed String: " + reversed);
    }
}

//Reversed String: olleh