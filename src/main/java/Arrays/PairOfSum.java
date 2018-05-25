package Arrays;

import General.helper.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Question:
 *  Design an algorithm to find all pairs of integers within an array which sum to a specific value
 *
 * Mistakes:
 *  - Do not forget to check if the complimentary count > 0
 *      if(map.containsKey(complementary) && map.get(complementary) >0){...
 *
 * Solution:
 *  1) Create a Hashmap with the key the unique integers in the array and value their occurrences.
 *  2) Iterate the array and for each selected value decrease the value of this number (to avoid selecting it again)
 *  3) calculate the complimentary and search if it exists & if value > 0
 *      3.1) If yes add the pair to the result and also decrease the value of the complimentary in the map
 *      3.2) If no update the value of the selected with +1 so that this number can be selected in future iteration.
 */
public class PairOfSum {
    public static ArrayList<Pair> findPairs(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        //Initialize map
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            } else {
                map.put(array[i],1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            //Remove current selected from map
            map.put(array[i], map.get(array[i])-1);

            int complementary = sum - array[i];
            if(map.containsKey(complementary) && map.get(complementary) >0){
                result.add(new Pair(array[i], complementary));
                map.put(complementary, map.get(complementary)-1);
            } else {
                map.put(array[i], map.get(array[i])+1);
            }
        }
        return result;
    }
}
