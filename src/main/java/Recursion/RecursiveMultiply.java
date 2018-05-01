package Recursion;

/**
 * Question:
 *  Write a recursive function to multiply 2 positive integers without using the '*'. You can use +, -, >>, << etc.
 *  You should minimize the number of those operations
 *
 * Mistakes:
 *
 * Solution:
 *
 *  1) First we need set the multiplication as the min number will multiply the max number so that we minimize the
 *     recursive calls.
 *  2) For the recursive function:
 *      If max or min == 0 return 0
 *      If min = 1 return max ( max * 1 = max)
 *
 *      Divide the min by 2 and call the recursive function for this half min.
 *      If min is even return result of half + result of half
 *      if min is odd  return result of half + result of half + max
 *
 */
public class RecursiveMultiply {
    public static int multiply(int i, int j) {

        if(i >= j){
            return multiplyHelper(i, j);
        } else{
            return multiplyHelper(j, i);
        }
    }

    private static int multiplyHelper(int max, int min){
        if(max ==0|| min == 0)
            return 0;

        if(min == 1){
            return max;
        }

        //divide min by 2
        int minDivided = min>>1;
        int half = multiplyHelper(max, minDivided);

        if (min %2 == 0){
            return half + half;
        } else {
            return half + half +max;
        }
    }
}
