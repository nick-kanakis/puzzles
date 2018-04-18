package Bit_Manipulation;

/**
 * Question:
 *  Write a program to swap odd and even bits in an integer with as few instructions as possible.
 *
 * Mistakes:
 *  >  0xaaaaaaa... == 1010101010101....
 *  >  0x5555555... == 0101010101010....
 *  > There is NO <<< !!!!!! logical shift only work for right shift not left shift
 *  > >> vs >>> :
 *
 ">> is arithmetic shift right, >>> is logical shift right.
 In an arithmetic shift, the sign bit is extended to preserve the signedness of the number.

 For example: -2 represented in 8 bits would be 11111110 (because the most significant bit has negative weight).
 Shifting it right one bit using arithmetic shift would give you 11111111, or -1.
 Logical right shift, however, does not care that the value could possibly represent a signed number;
 it simply moves everything to the right and fills in from the left with 0s.
 Shifting our -2 right one bit using logical shift would give 01111111."

 * Solution:
 *
 *  Select all even bits and logical shift them to the right by 1.
 *  Select all odd bits and logical shift them to the left by 1.
 *  OR both the results from above and return
 *
 */
public class PairwiseSwap {
    public static int pairwiseSwap(int number) {
        int maskOddPositionSelect = 0xaaaaaaaa; //101010...
        int maskEvenPositionSelect = 0x55555555; //010101...
        return ((number & maskOddPositionSelect)>>>1) |((number & maskEvenPositionSelect) << 1);
    }
}
