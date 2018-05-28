package Sorting_Searching;

/**
 * (CTCI 16.16) Question:
 *  Given an array of integers, write a method to find indices, m and n such that if you sorted elements m through n, the
 *  entire array would be sorted. Minimize the distance n,m
 *
 * Mistakes:
 *  - To expand left and right as pivot use the max/min elements of the middle section, not the first and
 *    last of the middle.
 *
 * Solution:
 *  1) Find the following:
 *      start index of the middle part: first value from the start that is on ascending order.
 *      end index of the middle part: first value from the end that is no in a descending order.
 *      max value of the middle array: max value between the 2 index described above
 *      min value of the middle array: min value between the 2 index described above
 *
 *  2) take the left part of the array and expand the middle (use as pivot the min value of the middle section)
 *     so that this min value greater than every element to the left.
 *
 *  3) take the right part of the array and expand the middle (use as pivot the max value of the middle section)
 *     so that this max value is less than every element ot the right.
 *
 */
public class SubSort {
    protected static class Middle{
        int startIndex = 0;
        int endIndex = 0;
        int maxIndex = 0;
        int minIndex = 0;

        public Middle(int startIndex, int endIndex, int maxIndex, int minIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.maxIndex = maxIndex;
            this.minIndex = minIndex;
        }
    }


    public static int[] subSort(int[] array) {
        Middle middle = findMiddleSection(array);

        int[] startEndOfSort = new int[2];

        startEndOfSort[0] = expandLeftSide(middle.startIndex, middle.minIndex, array);
        startEndOfSort[1] = expandRightSide(middle.endIndex, middle.maxIndex, array);

        return startEndOfSort;
    }

    private static Middle findMiddleSection(int[] array) {
        int startIndex = 0;
        int endIndex = 0;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]){
                startIndex = i+1;
                break;
            }
        }

        for (int i = array.length - 1; i > 0; i--) {
            if(array[i] < array[i - 1]){
                endIndex = i - 1;
                break;
            }
        }

        minIndex = minOfSubArray(array, startIndex, endIndex);
        maxIndex = maxOfSubArray(array, startIndex, endIndex);

        return new Middle(startIndex, endIndex, maxIndex, minIndex);

    }

    private static int maxOfSubArray(int[] array, int startIndex, int endIndex) {
        int max = endIndex;

        for (int i = startIndex; i <= endIndex; i++) {
            if (array[i] > array[max]){
                max = i;
            }
        }
        return max;
    }

    private static int minOfSubArray(int[] array, int startIndex, int endIndex) {
        int min = startIndex;

        for (int i = startIndex; i <= endIndex; i++) {
            if (array[i] < array[min]){
                min = i;
            }
        }
        return min;
    }

    private static int expandLeftSide(int startIndex, int minIndex, int[] array) {
        int startOfSortingPart = 0;

        for (int i = startIndex; i >=0 ; i--) {
            if(array[i]< array[minIndex]){
                startOfSortingPart = i + 1;
                break;
            }
        }
        return startOfSortingPart;
    }

    private static int expandRightSide(int endIndex, int maxIndex, int[] array) {
        int endOfSortingPart = array.length-1;

        for (int i = endIndex; i < array.length ; i++) {
            if(array[i] > array[maxIndex]){
                endOfSortingPart = i - 1;
                break;
            }
        }
        return endOfSortingPart;
    }

}
