package com.skcoder.interviewpoints.nums;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class BigIntegerSumWithCommaSeparator {
    void main() {
        String num1 = "9876543210123456789";
        String num2 = "1234567890987654321";

        // Convert strings to BigInteger
        BigInteger bigNum1 = new BigInteger(num1);
        BigInteger bigNum2 = new BigInteger(num2);

        // Perform addition
        BigInteger sum = bigNum1.add(bigNum2);
        System.out.println("sum: " + sum);

        // Format with commas every 3 digits based US
        String formattedUSResult = NumberFormat.getNumberInstance(Locale.US).format(sum);
        System.out.println("Formatted US Result: " + formattedUSResult);

        // Format with commas every 3 digits based IN
        NumberFormat indianFormat = NumberFormat.getInstance(Locale.of("en", "IN"));
        String formattedINResult = indianFormat.format(sum);
        System.out.println("Formatted IN Result: " + formattedINResult);
    }
}
