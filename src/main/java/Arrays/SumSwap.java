package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * (CTCI 16.21) Question:
 *      Given 2 arrays of integers, find a pair of values (one from each array) that you can swap to give the 2 arrays
 *      the same sum
 *
 * Mistakes:
 *  - The brute force is easy, try to solve it in O(n)!!
 *
 * Solution:
 *  - This equation must be true : sumA - a + b = sumB - b + a <=> a - b = (sumA - sumB)/2
 *
 *   1) Create a set of all arrayB values
 *   2) For every element in arrayA find the b (from b = a - (sumA - sumB)/2)
 *   3) If b contained in set of Bs return a,b else continue for the next possible a
 *
 */
public class SumSwap {
    public static int[] sumAndSwap(int[] arrayA, int[] arrayB) {

        int sumA = sumOf(arrayA);
        int sumB = sumOf(arrayB);

        Set<Integer> setB = getSet(arrayB);

        for (int i = 0; i < arrayA.length; i++) {
            int b = getB(sumA, sumB, arrayA[i]);
            if (setB.contains(b))
                return new int[]{arrayA[i],b};
        }

        return new  int[]{};
    }

    private static Set<Integer> getSet(int[] array){
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            setB.add(array[i]);
        }

        return setB;
    }

    private static int getB(int sumA, int sumB, int a){
        return a -(sumA - sumB)/2;
    }

    private static int sumOf(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
