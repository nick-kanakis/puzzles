package General;

/**
 * (CTCI 16.9) Question:
 *  Write methods to implement the following operations: *, +, -, /. using only the add operator. All are integers.
 *
 * Mistakes:
 *  - negate function!!
 *  - Watch out for negative and positive inputs, when you need to call negate at the end!
 *  - On multiplication: Do not do a = a + a do result = result + a;
 *  - It seems simple but you can make a lot of mistakes TEST THE CODE!!
 *
 * Solution:
 *  - Negate:
 *      code bellow
 *
 *  - Multiply:
 *      First before altering a,b check if we need to negate the final result.
 *      then use absolute to make values positive. Add a to itself b times and negate if needed
 *      SOS: do not do a = a + a do result = result + a;
 *
 *  - Divide:
 *      Like before check if need to negate the result. Then initiate the result with 1,
 *      Then calculate the diff = a - (result * b) if diff < b we cannot divide any longer return result
 *
 */
public class Operations {

    private static int negate(int a){
        int sign = a < 0? 1: -1;
        int neg = 0;

        /*
        * If a = 10
        *   sign = -1
        *   neg = 0, -1, -2, -3 ....
        *   a = 10, 9, 8, 7 ....
        *
        *   at the end a = - neg !
        * */
        while(a !=0){
           neg +=sign;
           a += sign;
        }
        return neg;
    }

    public static int multiply(int a, int b) {
        boolean shouldBeNegate = false;
        if(a <0 && b>0 || a>0 && b<0)
            shouldBeNegate= true;

        a = Math.abs(a);
        b = Math.abs(b);

        int result = 0;
        for (int i = 0; i < b; i++) {
            result = result + a;
        }
        if(shouldBeNegate)
            return negate(result);
        return result;
    }

    public static int divide(int a, int b) {
        boolean shouldBeNegate = false;

        if(a <0 && b>0 || a>0 && b<0)
            shouldBeNegate= true;

        a = Math.abs(a);
        b = Math.abs(b);

        int result = 1;

        while(true){
            int diff = a - multiply(result, b);

            if( diff < b)
                break;

            result++;
        }

        if(shouldBeNegate)
            return negate(result);
        return result;
    }

    public static int subtract(int a, int b) {
        return a + negate(b);
    }
}
