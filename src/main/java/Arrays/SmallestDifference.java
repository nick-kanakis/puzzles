package Arrays;
import java.util.Arrays;

/**
 * (CTCI 16.6) Question:
 *  Given 2 arrays of integers compute the pair of values (one from each array) with the smallest (non - negative) difference
 *
 * Mistakes:
 *  - Arrays must be sorted!!
 *  - First compute the difference and update the result, and then move the pointers!
 *
 * Solution:
 *  1) sort the arrays.
 *  2) create 2 pointers that point at the start of each array
 *  3) While both pointers are not out of bound
 *      3.1) Compute the new difference
 *      3.2) Move by 1 the pointer that points to the smallest value!
 */
public class SmallestDifference {

    public static Difference getMinDifference(int[] array1, int[] array2) {
        Difference diffPoints = new Difference(0,0, Integer.MAX_VALUE);

        int ptr1 = 0;
        int ptr2 = 0;
        int tmpDiff;
        Arrays.sort(array1);
        Arrays.sort(array2);


        while(ptr1 < array1.length && ptr2 < array2.length){
            tmpDiff = Math.abs(array1[ptr1] - array2[ptr2]);

            if(diffPoints.difference > tmpDiff){
                diffPoints.a = array1[ptr1];
                diffPoints.b = array2[ptr2];
                diffPoints.difference = tmpDiff;
            }

            if(array1[ptr1]< array2[ptr2]){
                ptr1++;
            } else {
                ptr2++;
            }

        }
        return diffPoints;
    }

    public static class Difference{
        public int a, b, difference;

        public Difference(int a, int b, int difference) {
            this.a = a;
            this.b = b;
            this.difference = difference;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Difference that = (Difference) o;

            if (a != that.a) return false;
            if (b != that.b) return false;
            return difference == that.difference;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + difference;
            return result;
        }

        @Override
        public String toString() {
            return "Difference{" +
                    "a=" + a +
                    ", b=" + b +
                    ", difference=" + difference +
                    '}';
        }
    }
}
