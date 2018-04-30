package Recursion;

/**
 * Question:
 *  A magic index in an array is defined to be an index such that A[i] = i. Given a sorted array of non-distinct integers write
 *  a method to find the magic index if it exists.
 *
 * Mistakes:
 *
 * Solution:
 *
 *  If A[i] == i
 *      You found the solution
 *  If A[i] > i
 *      search all the  left subarray (start <--> i-1 )
 *      search partially the right subarray ( A[i] <--> end )
 *  If A[i] < i
 *      search partially the left subarray (start <--> A[i])
 *      search all the right subarray (i+1 <--> end)
 */
public class MagicIndex {
    public static int findMagicIndex(int[] array) {

        return findMagicIndexHelper(array, 0, array.length - 1);
    }

    public static int findMagicIndexHelper(int[] array, int start, int end){
        if (start > end)
            return -1;
        int middle = (start + end)/2;

        if(array[middle] == middle){
            return middle;
        }
        else if(array[middle] > middle){
            //Search all the left subarray
           int resultLeft = findMagicIndexHelper(array, start, middle - 1);
           if(resultLeft >-1)
               return resultLeft;

           //Search from array[middle] <--> end
           int resultRight = findMagicIndexHelper(array, array[middle], end);
            if(resultRight >-1)
                return resultRight;

        } else {
            //Search from  start <--> array[middle]
            int resultLeft = findMagicIndexHelper(array, start, array[middle]);
            if(resultLeft >-1)
                return resultLeft;

            //Search all right subarray
            int resultRight = findMagicIndexHelper(array, middle + 1, end);
            if(resultRight >-1)
                return resultRight;

        }
        return -1;
    }
}
