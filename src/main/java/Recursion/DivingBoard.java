package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Question:
 *  You are building a diving board by placing planks end to end. There are 2 types of planks sort and long. You can use
 *  exactly K planks of wood. Write a method to generate all possible lengths.
 *
 * Mistakes:
 *
 * Solution:
 *  The problem can be solved recursively but a more optimal solution is iterative. Since we do not care about the
 *  position of the planks and only the final length, we do the following:
 *      1) Start from the max length = K * longest plank
 *      2) for 1-K replace a small plank with a long one
 *
 *      The final result will have all possible lengths.
 *
 */
public class DivingBoard {
    public static List<Integer> divingBoardsCombinations(int k, int shortPlank , int longPlank) {

        List<Integer> possibleSizes = new ArrayList<>();
        int maxSize = longPlank * k;
        possibleSizes.add(maxSize);

        for (int i = 0; i < k ; i++) {
            //Remove one long plank and add one short plank.
            maxSize = maxSize - longPlank + shortPlank;
            possibleSizes.add(maxSize);
        }
        return possibleSizes;
    }
}
