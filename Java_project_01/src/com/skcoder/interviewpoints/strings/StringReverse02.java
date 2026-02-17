package com.skcoder.interviewpoints.strings;

/*
 * Two Pointer Technique
 * Time Complexcity: O(n)
 * Space Complexcity: O(n)
 * */
public class StringReverse02 {
    void main() {
        String str = "hello";
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        char temp;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println("Reversed String: " + new String(arr));
    }
}

//Reversed String: olleh