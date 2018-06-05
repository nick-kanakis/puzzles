package General;

import java.util.ArrayList;
import java.util.Queue;

/**
 * (CTCI Q17.9) Question:
 *  Design an algorithm to find the kth number such that the only factors are 3,5,7. Note that 3,5,7 do not have to be factor,
 *  but there should have any other prime factors. eg: 1,3,5,7,9,15,21,....
 *
 * Mistakes:
 *  - When removing min values remove also any possible duplicated value!
 *
 * Solution:
 *  1) Create a list with tha values 3,5,7
 *  2) for 0...k do:
 *      1) pop min value from the list (and remove any duplicate value)
 *      2) Add to the queue, min*3, min*5, min*7
 *  3)Return min value
 *
 */
public class KthMultiple {

    public static int getKthMultiply(int k) {
        ArrayList<Integer> previousValues = new ArrayList<>();
        previousValues.add(3);
        previousValues.add(5);
        previousValues.add(7);

        int min = 0;

        for (int i = 0; i < k; i++) {
            min = removeMin(previousValues);
            previousValues.add(3* min);
            previousValues.add(5* min);
            previousValues.add(7* min);
        }
        return min;
    }

    private static int removeMin(ArrayList<Integer> previousValues) {
        int min = Integer.MAX_VALUE;

        for (Integer tmp: previousValues) {
            if(min> tmp){
                min = tmp;
            }
        }

        Integer toBeDeleted = new Integer(min);
        while(previousValues.contains(toBeDeleted)){
            previousValues.remove(toBeDeleted);
        }
        return min;
    }
}
