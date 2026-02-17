package com.skcoder.interviewpoints.strings;

/*
 * Time Complexcity: O(n2)
 * */
public class StringReverse01 {
    void main() {
        String str = "hello";
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        System.out.print("Reversed String: " + reversed);
    }
}

//Reversed String: olleh