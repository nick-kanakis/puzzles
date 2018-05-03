package Recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Question:
 *  Implement an algorithm to print all valid combinations of n pairs of parentheses.
 *
 * Mistakes:
 *
 * Solution:
 *  1) if pairs == 1 add () and return
 *  2) recurse for pair - 1
 *  3) for each string in the previous level (from the recurse function add right, left and aroun parentheses.
 *
 */
public class Parens {
    public static Set<String> generateParentheses(int pairs) {
        Set<String> set = new HashSet<>();
        if(pairs == 1){
            set.add("()");
            return set;
        }
        Set<String> previousParens= generateParentheses(pairs -1);

        for (String parens : previousParens) {
            set.add("()"+ parens);
            set.add(parens+"()");
            set.add("("+ parens+")");
        }
        return set;
    }
}
