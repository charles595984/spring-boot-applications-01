package com.skcoder.interviewpoints.strings;

import java.util.stream.IntStream;

/*
 * Time Complexcity: O(n)
 * Space Complexcity: O(n)
 * */
public class StringReverse04 {
    void main() {
        String str = "hello";
        String reversed = IntStream
                .range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
                ).toString();
        System.out.println("Reversed String: " + reversed);
    }
}

//Reversed String: olleh