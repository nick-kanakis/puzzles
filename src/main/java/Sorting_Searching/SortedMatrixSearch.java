package Sorting_Searching;

/**
 * Question:
 *  Given an M x N matrix in which each row & column is sorted in ascending order, write a method to find an element.
 *
 * Mistakes:
 *
 * Solution:
 * 1) Find the FIRST element in the diagonal that is greater than X that is called a pivot. Everything in the 4th quadrant is greater
 *    than the X. This means that we do not need to search this quadrant, also everything in the 1st quadrant is also
 *    smaller than X, so we do not have to search this one either.
 * 2) Recursively we search the 2 other quadrants (2nd and 3rd) in the same way.
 *
 */
public class SortedMatrixSearch {
    /*  .
        .
        .
    */
}
