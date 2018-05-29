package Recursion;

import java.util.Random;

/**
 * (CTCI 17.3) Question:
 *  Write a method to randomly generate a set of m integers from an array of size n.
 *  Each element must have equal probability of being chosen (where m < n)
 *
 * Mistakes:
 *
 * Solution:
 *  - Let's say we pulled m elements randomly from  N-1 elements, What we do for the N element:
 *    pick a number k between 0 - N-1, if this number is less than  m add N to k-th position of the subarray
 *
 *   So:
 *   1) Populate the subarray with the first m elements of the array.
 *   2) then from m till array.length do the following:
 *      2.1) pick a random number k from 0 - current position
 *      2.2) If k < m put the current element in K position
 *
 */
public class RandomSet {
    public static int[] randomPick(int[] array, int m) {
        int[] subarray = new int[m];
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
             subarray[i] = array[i];
        }

        for (int i = m; i < array.length; i++) {
            int randIndex = rand.nextInt(i);
            if( randIndex < m ){
                subarray[randIndex] = array[i];
            }
        }

        return subarray;
    }
}
