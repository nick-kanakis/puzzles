package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (CTCI Q17.18) Question:
 *  You are given 2 arrays one shorter (with distinct elements) and one longer. Find the shortest subarray in the longer array
 *  that contains all the elements in the shorter array. Items can appear in any order
 *
 * Mistakes:
 *  - Instead of using pointers to iterate the lists in the hashmap, you can use delete:
 *      eg:
 *          1-> |1|,10,11
 *          5-> |5|,7,12
 *          9-> |2|,9,15
 *
 *          In the first iteration the result is 1-5. (min-max numbers) delete the min (1) and you have
 *
 *          1-> |10|,11
 *          5-> |5|,7,12
 *          9-> |2|,9,15
 *
 *         In the second iteration the result is 2-10. (worst that previous so we discart it) delete the min (2) and you have
 *
 *          1-> |10|,11
 *          5-> |5|,7,12
 *          9-> |9|,15
 *
 *         In the third iteration the result is 5-10.  Delete the min (5) and you have....
 *
 * Solution:
 *  This a more complex problem of the basic find min diff between 2 arrays of integers.
 *  1) Create a hashmap with keys the distinct elements of the small array and value a list of all position
 *     of each key in the big array.
 *  2) While there is no empty list in the hashmap do:
 *      2.1) Compute the min & max value from the heads of the lists.
 *      2.2) If the distance of min - max indexes is smaller than the one current replace the min distance (initialized with max integer)
 *      2.3) remove the min head from the corresponding list.
 *
 */
public class ShortestSupersequence {
    public static int minDistance(int[] big, int[] small) {
        HashMap<Integer, ArrayList<Integer>> distinctElementIndexes = new HashMap<>();

        //Initialize map with distinct elements
        for (int s: small) {
            distinctElementIndexes.put(s, new ArrayList<>());
        }

        //Populate map with distinct elements indexes.
        for (int i = 0; i < big.length; i++) {
            if(distinctElementIndexes.containsKey(big[i]))
                distinctElementIndexes.get(big[i]).add(i);
        }


        //Iterate until a list is empty
        int minDistance = Integer.MAX_VALUE;
        while(!atLeastOneEmptyList(distinctElementIndexes)){
            int minOfHeads = Integer.MAX_VALUE;
            ArrayList<Integer> listWithMinValue = null;
            int maxOfHeads = Integer.MIN_VALUE;

            for (ArrayList<Integer> list: distinctElementIndexes.values()) {
                int head = list.get(0);
                if(head < minOfHeads){
                    minOfHeads = head;
                    listWithMinValue = list;
                }
                if(head > maxOfHeads){
                    maxOfHeads = head;
                }
            }
            listWithMinValue.remove(0);

            int diff = maxOfHeads - minOfHeads + 1;
            if(diff < minDistance)
                minDistance = diff;
        }

        return minDistance;
    }

    private static boolean atLeastOneEmptyList(HashMap<Integer, ArrayList<Integer>> distinctElementIndexes) {
        for (ArrayList<Integer> list: distinctElementIndexes.values()) {
           if(list.size() ==0)
               return true;
        }
        return false;
    }


}
