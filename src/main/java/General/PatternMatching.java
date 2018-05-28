package General;

/**
 * (CTCI 16.18) Question:
 *  Given 2 strings, pattern and value, write a method to determine if value matches pattern. The pattern string consists of
 *  just a,b
 *  eg: catcatgocatgo = aabab = ab = a = b
 *
 * Mistakes:
 *  - When you have a possible A you can compute the possible B as following:
 *      B size = total size of Bs / number of Bs
 *          while total size of Bs = total size - size of A * number of As.
 *      B starting index = size of A * position of first B in the pattern.
 *
 *  - Be careful if num of a or num of b == 0, you might divide with zero
 *
 *  - Iterate all max possible starting char:
 *      for (int i = 1; i <= maxLengthOfStarting; i++) { ...
 *      NOT (no equals)
 *      for (int i = 1; i < maxLengthOfStarting; i++) {
 *
 * Solution:
 *  1) Find some useful stats about the string:
 *      number of As
 *      number of Bs
 *      starting char & alternative char
 *      max length of starting char
 *
 *  2) Then for each possible length of starting start from "" to max length create possible A candidates.
 *     For each possible A compute the corresponding possible B:
 *          B size = total size of Bs / number of Bs
 *              while total size of Bs = total size - size of A * number of As.
 *          B starting index = size of A * position of first B in the pattern.
 *
 *  3) Validate by creating a new string based on possible A & possible B if equal to the original return true
 *      else increase the size of possible a (till we reach max length of A)
 */
public class PatternMatching {
    static int numOfA = 0;
    static int numOfB = 0;
    static char starting = 'a';
    static char alternative = 'b';

    public static boolean patternMatching(String pattern, String value) {
        int charsSum = value.length();
        int maxLengthOfStarting = 0;
        numOfA = findNumOf(pattern, 'a');
        numOfB = findNumOf(pattern, 'b');

        if(pattern.charAt(0) == 'a'){
            if(numOfA>0)
                maxLengthOfStarting = charsSum/numOfA;
        } else {
            starting = 'b';
            alternative = 'a';
            if(numOfB>0)
                maxLengthOfStarting = charsSum/numOfB;
        }

        return patternMatchingHelper(pattern,value,maxLengthOfStarting);
    }

    private static int findNumOf(String pattern, char token) {
        char[] chars = pattern.toCharArray();
        int count = 0;

        for (char c: chars ) {
            if(c == token){
                count++;
            }
        }
        return count;
    }

    private static boolean patternMatchingHelper(String pattern, String value, int maxLengthOfStarting) {
        String possibleA = "";
        String possibleB = possibleB(pattern,value, possibleA);

        if(validate(pattern, value, possibleA, possibleB))
            return true;

        for (int i = 1; i <= maxLengthOfStarting; i++) {
            possibleA = value.substring(0,i);
            possibleB =  possibleB(pattern, value, possibleA);
            if(validate(pattern, value, possibleA, possibleB))
                return true;
        }
        return false;
    }

    private static String possibleB(String pattern,  String value, String possibleA) {
        int sizeOfA = possibleA.length();
        int totalSizeOfAllB = value.length() - sizeOfA * numOfA;
        int sizeOfB = 0;
        if(numOfB == 0)
            return "";

        sizeOfB = totalSizeOfAllB /numOfB;
        int startingIndexOfB = sizeOfA*pattern.indexOf(alternative);

        return value.substring(startingIndexOfB, startingIndexOfB+sizeOfB);
    }


    private static boolean validate(String pattern, String value, String possibleA, String possibleB) {
        StringBuilder sb = new StringBuilder();

        char[] chars = pattern.toCharArray();
        for (char c: chars ) {
            if(c == 'a')
                sb.append(possibleA);
            else
                sb.append(possibleB);
        }

        return value.equals(sb.toString());
    }
}
