package com.skcoder.interviewpoints.strings;

import java.util.HashSet;
import java.util.Set;

/*
    Sliding Window Technique
    Time Complexity: O(n)
    Space Complexity: O(k)
*/

public class StringLongestUniqueSubstring {
    void main() {
        String s = "abcabcbb";
        int left = 0, right = 0;
        int maxLength = 0;
        int startIndex = 0;

        Set<Character> seen = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            // If duplicate found, shrink window from left
            while (seen.contains(c)) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(c);

            // Update max length and starting index
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
            right++;
        }
        String result = s.substring(startIndex, startIndex + maxLength);
        System.out.print("LongestUniqueSubstring: " + result);

    }
}
