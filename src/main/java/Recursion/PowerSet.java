package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * (CTCI 8.4) Question:
 *  Write a method to return all subsets of a set. eg: a,b,c returns: {},{a},{b},{c},{ab},{ac},{bc},{abc}
 *
 * Mistakes:
 *
 * Solution:
 *  Add the empty set to the result and do the following for each letter in the input
 *      1) Clone the list
 *      2) Add the letter to the cloned strings of the list
 *      3) Append the cloned list back to the original list
 */
public class PowerSet {
    public static ArrayList<String> getPowerSet(ArrayList<String> input) {
        ArrayList<String> result = new ArrayList<>();
        result.add("");

        for (String str: input) {
            ArrayList<String> cloned  = (ArrayList<String>) result.clone();
            for (int i = 0; i < cloned.size(); i++) {
                //Should be done with a string builder.
                cloned.set(i, cloned.get(i) + str);
            }
            result.addAll(cloned);
        }

        return result;
    }
}
