package Bit_Manipulation;

/**
 * (CTCI 17.1) Question:
 *  Write a function that adds 2 numbers, do not use any arithmetic operation.
 *
 * Mistakes:
 * - carry = a&b << 1 not simple a&b !!!
 *
 * Solution:
 *  - Add without carry = XOR (= sum)
 *  - Add with only the carry = AND + shift by 1 to the left(= carry)
 *
 *  1) Compute sum & carry
 *  2) If carry != 0 recursively call function and add sum, carry
 *  3) if carry == 0 result = sum + carry
 *
 */
public class AddWithoutPlus {
    public static int add(int a, int b) {
        if(a == 0)
            return b;
        if(b == 0)
            return a;

        int sum = a ^ b;
        int carry = (a&b)<<1;

        if(carry != 0){
            return add(sum, carry);
        }
        return a + b;

    }
}
