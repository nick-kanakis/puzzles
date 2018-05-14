package Sorting_Searching;

/**
 * Question:
 *
 *  You are given 2 sorted arrays, A & B, where A has a large enough buffer at the end to hold B. Write a method
 *  to merge B into A in sorted order.
 *
 * Mistakes:
 *
 *  > Watch for the first element of A. If you have the following while check: while( pointerA>=0 &&pointerB >=0) ...
 *  when the pointerA becomes negative the iteration will stop. This is wrong. There might be elements in B
 *  that have not been copied to A. we need to continue coping the elements of B to A.
 *
 * Solution:
 *
 *  Start from the end, compare the last elements of the A, B the biggest is moved to the end of A.
 *  Continue doing this until all elements of A & B have been checked!
 *
 */
public class SortedMerge {
    public static void sortedMerge(int[] a, int[] b, int actualEndOfA) {

        int pointerA = actualEndOfA;
        int pointerB = b.length - 1;
        int pointerMerged = a.length - 1;

        while(pointerB >=0){
            if (pointerA>=0 && a[pointerA] > b[pointerB]){
                a[pointerMerged] = a[pointerA];
                pointerA--;
            } else {
                a[pointerMerged] = b[pointerB];
                pointerB--;
            }
            pointerMerged --;
        }

    }
}
