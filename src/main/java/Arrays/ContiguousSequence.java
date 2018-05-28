package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * (CTCI 16.17) Question:
 *  You are given an array of integers (positive & negative). Find the contiguous sequence with the largest sum.
 *
 * Mistakes:
 *  - a+=b != a=+ b the first means a = a + b while the second is a=(+b)= b
 *
 * Solution:
 *  Iterate the array summing the elements, if sum < 0 set sum to 0 and continue. Keep the max sum and return it.
 *
 */
public class ContiguousSequence {
    public static int maxContiguousSequence(int[] array) {

        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum  += array[i];

            if(currentSum <0 ){
                currentSum = 0;
            } else if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
