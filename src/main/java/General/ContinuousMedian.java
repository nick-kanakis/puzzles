package General;

import java.util.ArrayList;

/**
 * (CTCI Q17.20) Question:
 *  Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value
 *  as new values are generated.
 *
 * Mistakes:
 *  - middle of an array = (size - 1)/2  NOT size/2
 *
 * Solution:
 *  - Add each element in a sorted order (binary insert).
 *  - When retrieving pick the middle of the array and return it,
 *    if array is even pick the 2 middles and return the mean of them.
 *
 *    Also:
 *    The problem can be solved by 2 heaps one max heap to keep the element left of the median and a min heap
 *    to keep the elements right of the media. (USE PRIORITY QUEUES) page 594 CTCI.
 *
 */
public class ContinuousMedian {
    ArrayList<Integer> sortedNums = new ArrayList<>();

    public void addElement(int randomElement) {
        binaryInsertion(randomElement, 0, sortedNums.size()-1);
    }

    private void binaryInsertion(int randomElement, int start, int end) {
        if(start>end){
            sortedNums.add(start, randomElement);
            return;
        }
        int mid = (start+end)/2;
        if(randomElement>sortedNums.get(mid)){
            binaryInsertion(randomElement,mid+1, end);
        } else {
            binaryInsertion(randomElement,start, mid-1);
        }
    }

    public int findMedian() {
        int middle = (sortedNums.size()-1)/2;
        if(sortedNums.size()%2 ==0){
            return (sortedNums.get(middle) + sortedNums.get(middle+1))/2;
        }
        return sortedNums.get(middle);
    }
}
