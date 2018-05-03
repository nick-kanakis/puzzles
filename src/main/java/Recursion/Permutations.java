package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ###SOS###
 *
 * Question:
 * Write a method to compute all permutations of a string whose characters are not necessarily unique. The resulted
 * list should not have duplicates
 *
 * Mistakes:
 *  > Do not forget to restore the count in the for loop.
 *
 * Solution:
 *
 * 1) Create a map of counts for the same chars.
 * 2) For each char in the map do the following:
 *  2.0) if length == 0 stop the recursive call and add the prefix to the list
 *  2.1) if char count > 0 count --
 *  2.2) recursively call the function for the new (decreased map), with a prefix = prefix + the current character, length - 1
 *  2.3) restore the count of the char for next character
 *
 * example for "aabb"
 *  map    prefix Decreased map
 *  |        |      |
 *  V        V      V
 * {a2b2} = [a + {a1b2}] + [b + {a2b1}] =
 *              [a + {a1b2}] =  [aa + {a0b2}] + [ab + {a1b1}] =
 *                  [aa + {a0b2}] =  [aab + {a0b1}] =
 *                      [aab + {a0b1}] = [aabb] + {a0b0}
 *                  [ab + {a1b1}] = [aba + {a0b1}] + [abb+ {a1b0}] =
 *                      [aba + {a0b1}]= [abab]  + {a0b0}
 *                      [abb+ {a1b0}] = [abba]  + {a0b0}
 *          [b + {a2b1}] =  [ba + {a1b1}] + [bb + {a2b0}] =
 *          .....
 *          .....
 *          .....
 *
 */
public class Permutations {
    public static List<String> findPermutation(String input) {
        HashMap<Character, Integer> map = buildMap(input);
        List<String> result = new ArrayList<>();
        helper(map, result, "", input.length());
        return result;
    }

    private static void helper(HashMap<Character, Integer> map, List<String> result, String prefix, int length) {
        //If remaining == 0 this means that in this branch the prefix holds a complete permutation and there is no
        //more chars to branch
        if (length == 0) {
            result.add(prefix);
            return;
        }
        for (Character c : map.keySet()) {
            Integer count = map.get(c);
            if (count > 0) {
                //We add this char to the prefix (as part of the permutation) so decrease it from the map.
                map.put(c, count - 1);
                //recursive call for the decreased map.
                helper(map, result, prefix + c, length - 1);
                //restore map frequency for use in next character.
                map.put(c, count);
            }
        }
    }

    private static HashMap<Character, Integer> buildMap(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }
}
