package Arrays;

/**
 * (CTCI Q17.10) Question:
 *  A majority is an element that makes up more than half of the items in an array. Given a positive integers array, find
 *  the majority element, if no majority element exists return -1. Do it O(n) time O(1) space.
 *
 * Mistakes:
 *  - The first part computes the candidate not the actual majority, in other words it computes the element that is
 *    most frequent relative to the position it is. This is not a majority element
 *
 * Solution:
 *  1) You must find the number that appears for be the majority element, this can be done by picking the first number
 *     as a candidate and count the number it appears and the number of the other elements. If this number is equal discard
 *     the candidate pick the next number and do the same.
 *  2) Verify that the number you have picked appears more than array.size/2 times!
 *
 *  Why the first part works: An element that is a majority appears at least array.size + 1 so by discarding the parts
 *      where countCandidates = countOfOtherElements will no hurt the overall majority element since it will catch up
 *      at the end.
 *
 */
public class MajorityElement {


    public static int findMajorityElement(int[] arrayWithMajority) {

        int countCandidates = 0;
        int countOfOtherElements = 0;
        int candidate = -1;

        for (int i = 0; i < arrayWithMajority.length; i++) {
            if(candidate == -1){
                candidate = arrayWithMajority[i];
                countCandidates++;
                continue;
            }
            if(candidate != arrayWithMajority[i])
                countOfOtherElements++;
            else
                countCandidates++;

            if(countCandidates == countOfOtherElements){
                countOfOtherElements = 0;
                countCandidates = 0;
                candidate = -1;
            }
        }

        if (verifyCandidate(candidate, arrayWithMajority))
            return candidate;
        return -1;
    }

    private static boolean verifyCandidate(int candidate, int[] array) {
        int countCandidates = 0;
        for (int i = 0; i <array.length ; i++) {
            if(array[i] == candidate)
                countCandidates++;
        }

        return countCandidates>array.length/2;
    }
}
