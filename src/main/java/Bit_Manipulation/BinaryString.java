package Bit_Manipulation;

/**
 * (CTCI 5.2) Question:
 *  Given a real number between 0 - 1 (0.72) that is passed in as a double, print the binary representation. If
 *  the number cannot be represented accurately in binary with at most 32 characters print "ERROR"
 *
 * Mistakes:
 * > Check if the double value is greater OR EQUAL to 1 not just greater.
 *   eg: (value >= 1) NOT (value > 1)
 *
 * Solution:
 *  0.0101 = [0* 2 ^-1] + [1* 2 ^-2] + [0* 2 ^-3] + [1* 2 ^-4]
 *
 *  So to print the decimal part of n we can multiply by 2 and check if 2n >= 1,
 *      If 2n >= 1 remove 1 and repeat until te value is 0.
 *      When the multiplied value is greater than 1 append 1 to binary result
 *      else append 0
 *
 */
public class BinaryString {
    public static String printBinary(double value) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");

        while(value > 0){
            value*=2;
             if (value >= 1){
                 value -= 1;
                 sb.append("1");
             } else {
                 sb.append("0");
             }

            if(sb.length()>32)
                return "ERROR";
        }
        return sb.toString();
    }
}
