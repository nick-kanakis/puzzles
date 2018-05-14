package Sorting_Searching;

/**
 * Question:
 *  Given a sorted array of n integers that has been rotated, write code to find an element in the array.
 *
 * Mistakes:
 *  > If solution has duplicates you must, Check the case where middle == end in this case:
 *      1) Check if middle is diff from the other side (the start) if it is then binary search that portion of the array.
 *      2) If it is the same binary search both sides.
 *  > Do not forget the equals when doing:  if(value > arr[mid] && value <= arr[end]) or  if(value >= arr[start] && value < arr[mid])
 *
 * Solution:
 *  The left or the right side of the array will be sorted correctly.
 *  If middle > start then the left part is correctly sorted.
 *      if value >= start &  value < middle then search the left part else search the right part
 *  If middle < start then the left part is incorrect ( so the right part is correctly sorted)
 *      if value > middle & value =< end then search the right part else search the left part
 *  If middle == start then we have a duplicate
 *      Check if middle != end and search the right part
 *      else search both sides
 *
 */
public class SearchRotatedArray {
    public static int search(int[] arr, int value) {
        return binarySearch(arr,value, 0, arr.length-1);
    }

    private static int binarySearch(int[] arr, int value, int start, int end){
        int mid = (start + end)/2;

        if(start>end)
            return -1;
        if(arr[mid] == value)
            return mid;

        //if arr[mid] < arr[end] means that the right part is sorted correctly
        if(arr[mid] < arr[end]){
            if(value > arr[mid] && value <= arr[end]){
                return binarySearch(arr, value, mid + 1, end);
            } else {
                return binarySearch(arr, value, start, mid - 1);
            }
        } else if (arr[mid] > arr[end]){
            //the correctly sorted path is the left part of the array
            if( value >= arr[start] && value < arr[mid] ){
                return binarySearch(arr, value, start, mid - 1);
            } else {
                return  binarySearch(arr, value, mid + 1, end);
            }
        } else if(arr[mid] == arr[end]) {
            //In case we have arr[mid] == arr[end] check the arr[start]
            if(arr[mid] != arr[start]){
                return binarySearch(arr, value, start, mid - 1);
            } else {
                int result = binarySearch(arr, value, mid + 1, end);
                if (result != -1) {
                    return result; }
                    else {
                    return binarySearch(arr, value, start, mid - 1);
                }
            }
        }
        return -1;
    }
}
