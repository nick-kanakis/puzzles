package General;

/**
 * (CTCI 16.8) Question:
 * Given any integer, print the English phrase that describes the integer.
 * <p>
 * Mistakes:
 * - Leave empty slots in the tens  in order to match indexes with values eg:
 * index 2 = Twenty.
 * - Do not forget negative values!
 * - Watch out for edge cases (zero, things that should not be printed etc.)
 *
 * Solution:
 *  Split the number in 3 digits and compute the string value of them, then join them with the add of thousand/million etc.
 *
 */
public class EnglishInt {
    public static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million", "Billion"};
    public static String hundred = "Hundred";
    public static String negative = "Negative";

    public static String intToEnglish(int number) {
        String finalString = "";
        boolean negative = number < 0;

        if (number == 0)
            return smalls[0];

        for (int i = 0; number > 0; i++) {
            int hundred = number % 1000;
            number = number / 1000;
            finalString = computeHundred(hundred) + " " + bigs[i] + " " + finalString;
        }

        if (negative)
            finalString = negative + " " + finalString;

        return finalString;
    }

    private static String computeHundred(int input) {
        String result = "";
        int last2digits = input % 100;
        //if input was 123, now it is 1
        input = input / 100;

        //If input == 0 this means that the input is less than 100. so do not add "hundred" to the result
        if (input != 0) {
            result = smalls[input] + " " + hundred;
        }

        //eg: 400
        if (last2digits == 0)
            return result;

        // eg: x19
        if (last2digits < 20) {
            result = result +" "+ smalls[last2digits];
            return result;
        }

        int lastDigit = last2digits % 10;

        //If input was 123 now it is 2
        int second2LastDigit = last2digits / 10;

        if (second2LastDigit != 0) {
            result = result +" "+ tens[second2LastDigit];
        }

        if(lastDigit!=0)
            result  = result +" "+ smalls[lastDigit];

        return result;
    }
}
