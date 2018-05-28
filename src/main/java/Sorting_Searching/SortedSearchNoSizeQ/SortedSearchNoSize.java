package Sorting_Searching.SortedSearchNoSizeQ;

/**
 * (CTCI 10.4) Question:
 *  Given an array-like DS Listy which lacks the a size method, however it has a elementAt(i) method that returns index
 *  at index i or -1 if out of bound. Given a Listy which contains sorted, positive integers if the index at which an element
 *  occurs.
 *
 * Mistakes:
 *
 * Solution:
 *  First find the max index:
 *      Search the listy for -1 or a number > the value we are searching for.
 *      The steps are exponential eg, 1,2,4,8,16,32,64 ....
 * Then do a mostly normal binary search with one exception:
 *  If the middle element is -1 then this means that it is out of bound (aka > value) so search the left subtree
 *
 */
public class SortedSearchNoSize {
    public static int search(Listy list, int value) {
        int maxIndex = calculateMaxIndex(list, value);

        return binarySearch(list, 0, maxIndex, value);

    }

    private static int binarySearch(Listy list, int min, int max, int value) {
        if(min > max)
            return -1;

        int middle = (min + max) / 2;

        if(list.getElementAt(middle) == value)
            return middle;

        else if(list.getElementAt(middle)== -1 ||  value < list.getElementAt(middle)){
            return binarySearch(list, min, middle -1, value);
        } else {
            return binarySearch(list, middle + 1, max, value);
        }
    }

    private static int calculateMaxIndex(Listy list, int value) {
        int maxIndex = 1;
        int element = list.getElementAt(maxIndex);
        while ( element!= -1 && element < value){
            maxIndex *=2;
            element = list.getElementAt(maxIndex);
        }
        return maxIndex;
    }
}
