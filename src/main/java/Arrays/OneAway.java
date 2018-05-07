package Arrays;


/**
 * Question: There are 3 types of edits that can be performed on strings: insert a char, remove a char or replace a char.
 * Given 2 strings write a function to check if they are one edit away.
 *
 * eg:
 * pale, ple ->true
 * pales, pale -> true
 * pale, bake -> false
 *
 *
 * Mistakes:
 * > Do not try to solve it with one function, tackle each case separately.
 * > The checkInsert is tricky, use 2 pointers for the words,
 *   keep in mind to move the pointer of smaller only if there is no problem
 *
 * Solution:
 * First check if the strings length diff is more than 2, or if they are equal.
 *
 * If diff == 0 then check if the edit is a replace
 * Else if diff  == 1 || diff == -1 check if edit is insert (or remove with swapped arguments)
 *
 * In the checkReplace if there are more than 2 diffs return false (use a bool and not a counter)
 *
 * In the checkInsert check the first common chars of the 2 strings (use 2 pointers).
 * If there is a diff use the same flag as previous to mark it, and move only longest's word pointer,
 * if there is a diff again return false.
 * At the end return true.
 *
 */
public class OneAway {

    public static boolean isOneAway(String s1, String s2){
        int diff = s1.length() - s2.length();
        if (Math.abs(diff) > 1 )
            return false;

        if(s1.equals(s2))
            return true;

        if(diff==0 ){
            return checkReplace(s1.toCharArray(), s2.toCharArray());
        } else {
             if (diff > 0){
                 return  checkInsert(s1.toCharArray(), s2.toCharArray());
             }
             return checkInsert(s2.toCharArray(), s1.toCharArray());
        }
    }

    private static boolean checkReplace(char[] str1, char[] str2) {
        boolean diffFound = false;
        for (int i = 0; i < str1.length; i++) {
            if(str1[i] != str2[i]){
                if (diffFound)
                    return false;
                else
                    diffFound = true;
            }
        }
        return true;
    }

    private static boolean checkInsert(char[] big, char[] small) {
        int counterBig = 0;
        int counterSmall = 0;
        boolean diffFound = false;

        while (counterBig < big.length && counterSmall<small.length){
            if(big[counterBig] != small[counterSmall]){
                if(diffFound)
                    return false;
                diffFound = true;
            } else {
                counterSmall++;
            }
            counterBig++;
        }
        return true;
    }


}
