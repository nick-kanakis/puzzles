package General;

import General.helper.Pair;

/**
 * (CTCI 16.1) Question:
 *  Write a function to swap a number in place (No temporary variables)
 *
 * Mistakes:
 *
 * Solution:
 *  1) Find the diff between a - b store it in the a
 *  2) Calculate final value of b by doing b - a  = b - diff = a
 *  3) Calculate final value of a by doing a + b = diff + a = b
 */
public class NumberSwapper {

    public static Pair swapInPlace(Pair pair) {
        Pair cloned = pair.clone();
        cloned.a = cloned.b - cloned.a;
        cloned.b = cloned.b - cloned.a;
        cloned.a = cloned.a + cloned.b;

        return cloned;
    }
}
