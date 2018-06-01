package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  (CTCI Q17.14) Question:
 *  Design an algorithm to find the smallest K elements in an array of integers
 *
 * Mistakes:
 *  - Use a max heap comparator to always keep the max element on top. So you can poll it when the size is full and move
 *    a new integer!
 *  - Priority queue is a queue with sorted with min on the end (this is the same as a min heap) to make it a max queue
 *    (or a max heap in other words) create a new Comparator that returns <0 when b > a (so do b - a) instead of a - b
 *
 * Solution:
 *  It is easy to solve it with iteration try to solve it with a max heap (priority queue)
 *  1) Create a max heap with the smallest K elements
 *      if heap size is not k add elements from array to heap
 *      If heap size == k poll the element (the largest) and add the new element.
 *  2) Then transform the heap to a integer array
 *      poll each element from heap until it is empty and put it in the array starting from the end to the start, because
 *      the polled item will always be the largest
 *
 */
public class KthSmaller {
    public static int[] kthSmallest(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = getKMaxHeap(array, k);
        return heapToInt(maxHeap);
    }

    private static PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new maxHeapComparator());

        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k){
                maxHeap.add(array[i]);
            } else if( maxHeap.peek() > array[i]){
                maxHeap.poll();
                maxHeap.add(array[i]);
            }
        }
        return maxHeap;
    }

    private static int[] heapToInt(PriorityQueue<Integer> maxHeap) {
        int[] result =  new int[maxHeap.size()];

        while(!maxHeap.isEmpty()){
            result[maxHeap.size()-1] = maxHeap.poll();
        }

        return result;
    }

    private static class maxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b-a;
        }
    }
}
