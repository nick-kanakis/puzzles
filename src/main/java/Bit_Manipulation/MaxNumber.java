package Bit_Manipulation;

/**
 * Question:
 *  Write a method that finds the max of 2 numbers, you cannot use if-else or any other comparison operator.
 *
 * Mistakes:
 *  - Most significant bit can be calculated by shifting 31 or 63  times to the right.
 * Solution:
 *
 */
public class MaxNumber {
    public static int findMax(int a, int b) {
        int diff = a - b;
        int msb =  mostSignificantBit(diff);

        return (1 - msb)*a + msb*b;
    }

    private static int mostSignificantBit(int diff) {
        return (diff>>63) & 1;
    }
}
