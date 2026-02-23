package com.skcoder.interviewpoints.nums;

/*
Why this is better for large arrays
- Time complexity: O(n) — only one pass through the array.
- Space complexity: O(1) — no extra data structures.
- Works even if the array is unsorted and contains duplicates.
*/

public class SecondHighestUsingOnePass {
    void main() {
        int[] numbers = {12, 35, 1, 10, 34, 1};

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest && num < highest) {
                secondHighest = num;
            }
        }

        if (secondHighest == Integer.MIN_VALUE) {
            System.out.println("No second highest number exists.");
        } else {
            System.out.println("Second highest number: " + secondHighest);
        }

    }
}
