package Bit_Manipulation;

import java.util.ArrayList;

/**
 * (CTCI 5.3) Question:
 *  Given an integer, you can flip only one bit, write code to find the longest sequence of 1s possible
 *
 * Mistakes:
 *  > use i<Integer.BYTES to loop all bits in the integer
 *  > Do not forget the -1 case where everything is 1
 *
 * Solution:
 *
 *  First create a "map" of how many 1s and 0s exist in sequence, always starting from 0
 * eg. 11000011100 = 02432 = 0(zeros)2(ones)4(zeros)3(ones)2(zeros)
 *      To map the bits do a for loop for i=0; i<Integer.BYTES * 8; i++
 *
 * Having that map we pass to to a function to check what is the maximum sequence of ones it is able to have.
 *  for each 0 slot in the map ( positions 0, 2, 4, 5 ....)
 *      calculate left 1s & right 1s
 *      if num of 0s >1
 *          tmpMax = max(left 1s, right 1s) + 1
 *      if num of 0s == 1
 *          tmpMax = lef 1s + right 1s  + 1
 *      if num of 0s == 0
 *          tmpMax = max(left 1s, right 1s)
 *  if max < tmp max replace
 */
public class FlipBitToWin {
    public static int flipToWin(int number) {
        if (number == -1 ){
            return Integer.BYTES *8;
        }

        ArrayList<Integer> map = new ArrayList<>();
        int counter = 0;
        int searching = 0;
        for (int i = 0; i < Integer.BYTES *8; i++) {
            if((number & 1) != searching){
                map.add(counter);
                searching = number & 1;
                counter = 0;
            }
            counter ++;
            number >>>= 1;
        }

        return getMax(map);
    }

    private static int getMax(ArrayList<Integer> map) {
       int max = -1;

        for (int i = 0; i < map.size(); i+=2) {
            int zeroCount = map.get(i);
            int tmpMax = 0;

            int leftOnes = i -1 >=0 ? map.get(i - 1) : 0;
            int rightOnes = i + 1 < map.size() ? map.get(i+1) : 0;

           if (zeroCount > 1){
                tmpMax = Math.max(leftOnes, rightOnes) + 1;
            } else {
                tmpMax = leftOnes + rightOnes + 1;
            }
            if(tmpMax > max)
                max = tmpMax;
        }
        return max;
    }
}
