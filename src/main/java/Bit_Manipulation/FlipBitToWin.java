package Bit_Manipulation;

/**
 * Question:
 *  Given an integer, you can flip only one bit, write code to find the longest sequence of 1s possible
 *
 * Mistakes:
 *  > Do not forget to assign re result of a >>, | or & back to the value
 *    num = num >> 1
 *
 * Solution:
 *  My solution
 *  Iterate the bit by bit the original number if a bit is 0 flip it to 1.
 *  Pass the new flipped number to a function that counts the max number of.
 *      When iterating bit by bit, use a mask = 1 and shift it until mask > number,
 *      Do not forget to check the case tha the number  = 11111 so the mask must be
 *      greater than number (mask = 100000).
 *
 *  More time efficient solution:
 *  First create a "map" of how many 1s and 0s exist in sequence, always starting from 0
 * eg. 11000011100 = 02432 = 0(zeros)2(ones)4(zeros)3(ones)2(zeros)
 *
 * Having that map we pass to to a function to check what is the maximum sequence of ones it is able to have.
 */
public class FlipBitToWin {
    public static int flipToWin(int number) {
        int max = 0;
        int tmpMax = 0;
        int flippedMask = 1;

        while (flippedMask <= number) {
            int oneBitFlipped = flippedMask | number;
            tmpMax = countOnes(oneBitFlipped);
            if (tmpMax > max)
                max = tmpMax;
            flippedMask = flippedMask << 1;
        }

        int oneBitFlipped = flippedMask | number;
        tmpMax = countOnes(oneBitFlipped);
        if (tmpMax > max)
            max = tmpMax;
        return max;
    }

    private static int countOnes(int num) {
        int count = 0;
        int max = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
                if (count > max)
                    max = count;
            } else {
                count = 0;
            }
            num = num >> 1;
        }
        return max;
    }
}
